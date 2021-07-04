package com.springsecurity.api;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class
) @ExtendWith({SpringExtension.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureWebTestClient
public class WebApplicationSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testSayHi() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/")
                        .queryParam("name", "Bro")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hi there, Bro.");
    }
    
    //@Test
    @WithUserDetails("toto@toto.com")
    public void givenManagerUser_whenGetFooSalute_thenOk() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/signin")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("toto@toto.com"));
    }

    //@Test
    @WithUserDetails("tata@tata.com")
    public void givenBasicUser_whenGetFooSalute_thenForbidden() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/signin")
                .accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }
}

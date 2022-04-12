package com.springsecurity.api.controllers;

import com.springsecurity.api.SpringSecurityWebAuxTestConfig;
import com.springsecurity.api.mocks.IWithMockAdmin;
import com.springsecurity.api.mocks.IWithMockModerator;
import com.springsecurity.api.mocks.IWithMockUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class PetsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @IWithMockAdmin
    public void getPets_shouldReturnOk() throws Exception {
        this.mockMvc.perform(get("/api/pets")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @IWithMockModerator
    public void getPets_shouldReturnOkModeratorUser() throws Exception {
        this.mockMvc.perform(get("/api/pets")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @IWithMockUser
    public void getPets_shouldReturnOkBasicUser() throws Exception {
        this.mockMvc.perform(get("/api/pets")).andDo(print()).andExpect(status().isOk());
    }
}

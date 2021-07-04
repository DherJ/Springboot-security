package com.springsecurity.api.mocks;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(value="rob",roles="USER")
public @interface IWithMockUser {
}

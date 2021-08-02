package com.springsecurity.api.mocks;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockModeratorSecurityContextFactory.class)
public @interface IWithMockModerator {
    String username() default "Moderator User";
}

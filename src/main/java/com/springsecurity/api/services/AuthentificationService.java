package com.springsecurity.api.services;

import com.springsecurity.api.http.request.SignUpRequest;
import com.springsecurity.api.http.request.SigninRequest;
import com.springsecurity.api.http.response.JwtAuthenticationResponse;

public interface AuthentificationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}

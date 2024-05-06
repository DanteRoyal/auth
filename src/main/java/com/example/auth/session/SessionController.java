package com.example.auth.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.request.LoginRequest;
import com.example.auth.request.SignupRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionController {

	private final SessionService sessionService;

	@PostMapping
	@RequestMapping("/signup")
	public void signup(@RequestBody final SignupRequest request) {
		sessionService.signup(request);
	}

	@PostMapping
	@RequestMapping("/login")
	public void login(@RequestBody final LoginRequest request) {
		sessionService.login(request);
	}
}

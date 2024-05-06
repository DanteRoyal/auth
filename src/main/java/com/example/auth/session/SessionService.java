package com.example.auth.session;

import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.example.auth.domain.User;
import com.example.auth.request.LoginRequest;
import com.example.auth.request.SignupRequest;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {

	private final SessionRepository sessionRepository;

	private final HttpSession httpSession;

	public void signup(final SignupRequest request) {

		User signupUser = User.builder()
			.username(request.getUsername())
			.password(request.getPassword())
			.build();

		sessionRepository.save(signupUser);
	}

	public void login(LoginRequest request) {
		User foundUser = sessionRepository.findByUsername(request.getUsername())
			.orElseThrow(() -> new RuntimeException("해당 유저 없음"));

		if (!foundUser.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("비밀번호 틀림");
		}

		httpSession.setAttribute("loginUser", foundUser);
		log.info("session={}", httpSession.getId());
	}
}

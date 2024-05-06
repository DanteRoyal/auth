package com.example.auth.session;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.domain.User;
import com.example.auth.request.LoginRequest;

@Repository
public interface SessionRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}

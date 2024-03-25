package com.project.backend.security.service;

import com.project.backend.model.dao.User;
import com.project.backend.model.repository.UserRepository;
import com.project.backend.security.service.impl.UserDetailsServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserDetailsServiceImpl userDetailsService;

	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadUserByUsername() {
		User user = new User();
		user.setUsername("testUser");
		user.setPassword("testPassword");

		when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

		assertEquals(user.getUsername(), userDetails.getUsername());
		verify(userRepository, times(1)).findByUsername(user.getUsername());
	}
}

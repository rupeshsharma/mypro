package com.my.pro.service.user.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.pro.domain.Role;
import com.my.pro.domain.User;
import com.my.pro.repository.UserRepository;
import com.my.pro.service.user.RoleService;
import com.my.pro.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	public void create(User user) {
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleService.findByName("ROLE_USER"));
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);
	}

	public User getCurrentLoggedInUser() {
		Object user = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (user instanceof UserDetails) {
			return (User) user;
		} else {
			return null;
		}
	}
}

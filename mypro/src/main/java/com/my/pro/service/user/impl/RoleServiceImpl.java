package com.my.pro.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.pro.domain.Role;
import com.my.pro.repository.RoleRepository;
import com.my.pro.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

}

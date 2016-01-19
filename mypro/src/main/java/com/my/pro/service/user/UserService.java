package com.my.pro.service.user;

import com.my.pro.domain.User;

public interface UserService {

	User findByUsername(String username);

	void create(User user);

	User getCurrentLoggedInUser();

}

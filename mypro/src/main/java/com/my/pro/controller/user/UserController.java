package com.my.pro.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.pro.domain.User;
import com.my.pro.service.user.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String toUserPage(Model model) {
		model.addAttribute("user", userService.getCurrentLoggedInUser());
		model.addAttribute("msg", "THIS IS USER PAGE");
		return "user";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult result, Model model) {
		userService.create(user);
		return "redirect:/";

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		return "createUser";

	}

}

package com.my.pro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toHomePage(Model model) {
		model.addAttribute("msg", "THIS IS HOME");
		return "home";
	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		return "accessdenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLoginPage(Model model,
			@RequestParam(value = "error", required = false) String error) {
		model.addAttribute("msg", "THIS IS LOGIN");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String toLoginPage(HttpServletRequest request, HttpServletResponse response) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
		return "redirect:/login?logout";
	}

}

package com.courier.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showIndexPage() {

		return "index";
	}

	@GetMapping("index")
	public String showHomePage(HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String userName = null;
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();

		} else {
			userName = principal.toString();
		}

		session.setAttribute("loggedUser", userName);
		return "index";
	}

	@GetMapping("logout")
	public String showLogOut() {

		return "login";
	}

	@GetMapping("login")
	public String showIndex() {

		return "login";
	}

	@GetMapping("accessDenied")
	public String showAccessDenied() {

		return "accessDenied";
	}
}

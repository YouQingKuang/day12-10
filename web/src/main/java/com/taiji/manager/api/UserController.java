package com.taiji.manager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taiji.manager.sevice.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping("list")
	public String test(Model medol) {
		return "list";
	}
}

package com.javateam.TimeLabel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/error/*")
public class ErrorController {

	@GetMapping("/404")
	public String defaultError() {
		return "/error/404";
	}

	@GetMapping("/403")
	public String noResource() {
		return "error/403";
	}

	@GetMapping("/500")
	public String serverError() {
		return "error/500";
	}
}

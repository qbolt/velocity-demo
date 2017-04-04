package com.fedex.airops.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.airops.service.TemplateService;

@RestController
public class MainController {

	TemplateService templateService;
	
	public MainController(TemplateService templateService) {
		this.templateService = templateService;
	}
	
	@GetMapping("/")
	public String getIndex(HttpSession session) {
		return templateService.getTemplate("index.vm", session);
	}
	
	@GetMapping("/updateFilter")
	public String updateFilter(HttpSession session, @RequestParam(value="filter") String filter) {
		session.setAttribute("filter", filter);
		return filter;
	}
	
	@GetMapping("/setCurrentPerson")
	public String setCurrentPerson(HttpSession session, @RequestParam(value="currentPerson") String currentPerson) {
		session.setAttribute("currentPerson", currentPerson);
		return currentPerson;
	}
}

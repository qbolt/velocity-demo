package com.fedex.airops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.airops.service.TemplateService;

@RestController
public class MainController {

	TemplateService templateService;
	
	public MainController(TemplateService templateService) {
		this.templateService = templateService;
	}
	
	@GetMapping("/")
	public String getIndex() {
		return templateService.getTemplate("index.vm");
	}
	
	@PostMapping
	public String updateFilter() {
		System.out.println("updating filter");
		return "success";
	}
}

package com.fedex.airops.service;

import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {

	DataService dataService;
	
	VelocityEngine velocity;
	
	@Autowired
	public TemplateService(DataService dataService) {
		
		this.dataService = dataService;
		
		this.velocity = new VelocityEngine();
		
		Properties properties = new Properties();
		properties.put("file.resource.loader.path", "src/main/resources/templates");
		
		velocity.init(properties);
	}
	
	public String getTemplate(String templateName, HttpSession session) {
		
		String filter = "";
		
		if (session.getAttribute("filter") != null)
			filter = session.getAttribute("filter").toString();
		
		Template template = velocity.getTemplate(templateName);
		
		VelocityContext context = new VelocityContext();
		context.put("personList", dataService.getPersonData(filter));
		context.put("filter", filter);
		
		StringWriter writer = new StringWriter();
        template.merge(context, writer);

        String result = writer.toString();

        return result;
	}
	
}

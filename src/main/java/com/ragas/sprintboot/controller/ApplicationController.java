/**
 * 
 */
package com.ragas.sprintboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.sprintboot.configuration.ApplicationConfiguration;
import com.ragas.sprintboot.configuration.SecurityConfiguration;

/**
 * @author Chandra.Jagarlamudi
 *
 */
@RestController
public class ApplicationController {
	@Autowired
	private ApplicationConfiguration applicationProperties;
	
	@Autowired
	private SecurityConfiguration securityConfiguration;

	@GetMapping("/")
	public Map<String, String> getAppDetails() {
		Map<String, String> appDetails = new HashMap<>();
		appDetails.put("name", applicationProperties.getName());
		appDetails.put("description", applicationProperties.getDescription());
		appDetails.put("roles", securityConfiguration.getRoles().toString());
		appDetails.put("permissions", securityConfiguration.getPermissions().toString());

		return appDetails;
	}

}

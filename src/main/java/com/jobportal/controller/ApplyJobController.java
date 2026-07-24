package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.entity.ApplyJob;
import com.jobportal.service.ApplyJobService;

import jakarta.servlet.http.HttpSession;



@Controller
public class ApplyJobController {
	
	@Autowired
	private ApplyJobService applyJobService;
	
	@GetMapping("/apply")
	public String applyPage() {
	    return "applyjob";
	}
	
	@PostMapping("/saveApplication")
	public String saveApplication(ApplyJob applyJob) {

	    applyJobService.saveApplication(applyJob);

	    return "index";
	}
	
	@GetMapping("/applications")
	public String viewApplications(HttpSession session, Model model) {

	    if (session.getAttribute("loggedUser") == null) {
	        return "login";
	    }

	    model.addAttribute("application", applyJobService.getAllApplications());

	    return "applications";
	}

}

package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import com.jobportal.entity.Job;
import com.jobportal.service.JobService;

@Controller
public class Jobcontroller {
	
	@Autowired
	private JobService jobService;
	
	
	@GetMapping("/addJob")
	public String addJobPage(HttpSession session) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "login";
		}
		return "addjob";
	}
	
	
	@PostMapping("/saveJob")
	public String saveJob(Job job) {
		
		jobService.saveJob(job);
		
		return "index";
	}
	
	
	@GetMapping("/jobs")
	public String viewJobs(HttpSession session, Model model) {
		
		if (session.getAttribute("loggedUser") == null) {
			return "login";
		}
		
		model.addAttribute("jobs", jobService.getAllJobs());
		
		return"jobs";
	}
	
	
	@GetMapping("/deleteJob/{id}")
	public String deleteJob(@PathVariable Long id) {
		
		jobService.deleteJob(id);
		
		return "redirect:/jobs";
	
	}
	
	
	@GetMapping("/editJob/{id}")
	public String editJob(@PathVariable Long id, Model model) {

	    Job job = jobService.getJobById(id);

	    model.addAttribute("job", job);

	    return "editjob";
	}
	
	
	@PostMapping("/updateJob")
	public String updateJob(Job job) {

	    jobService.updateJob(job);

	    return "redirect:/jobs";
	}
	
	@GetMapping("/searchJobs")
	public String searchJobs(@RequestParam("keyword") String keyword,
	                         Model model,
	                         HttpSession session) {

	    if (session.getAttribute("loggedUser") == null) {
	        return "login";
	    }

	    model.addAttribute("jobs", jobService.searchJobs(keyword));

	    return "jobs";
	}
	
	
	

}

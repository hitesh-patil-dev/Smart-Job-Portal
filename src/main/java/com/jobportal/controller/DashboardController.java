package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

 @Autowired
 private JobRepository jobRepository;

 @Autowired
 private UserRepository userRepository;

 @GetMapping("/dashboard")
 public String dashboard(Model model, HttpSession session) {

      if (session.getAttribute("loggedUser") == null) {
          return "login";
      }

      model.addAttribute("totalJobs", jobRepository.count());
      model.addAttribute("totalUsers", userRepository.count());

      return "dashboard";
  }

}
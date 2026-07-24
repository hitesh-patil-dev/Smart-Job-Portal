package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entity.ApplyJob;
import com.jobportal.repository.ApplyJobRepository;

@Service
public class ApplyJobService {
	
	@Autowired
	private ApplyJobRepository applyJobRepository;
	
	public ApplyJob saveApplication(ApplyJob applyJob) {
		return applyJobRepository.save(applyJob);
	}
	
	public List<ApplyJob> getAllApplications() {
		return applyJobRepository.findAll();
	}

}

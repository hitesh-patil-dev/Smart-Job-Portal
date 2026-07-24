package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.entity.ApplyJob;

public interface ApplyJobRepository extends JpaRepository<ApplyJob, Long> {

}
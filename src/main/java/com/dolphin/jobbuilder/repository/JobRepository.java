package com.dolphin.jobbuilder.repository;

import com.dolphin.jobbuilder.entity.JobEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, String> {
}

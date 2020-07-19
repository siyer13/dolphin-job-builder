package com.dolphin.jobbuilder.service;

import com.dolphin.jobbuilder.entity.JobEntity;
import com.dolphin.jobbuilder.ms.Job;
import com.dolphin.jobbuilder.ms.JobSubmit;
import com.dolphin.jobbuilder.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Job> getAllJobs() {

        List<JobEntity> jobEntity = jobRepository.findAll();

        List<Job> jobList =  jobEntity.stream().map(j -> {
            Job job = new Job();
            job.setJobId(j.getJobId());
            job.setJobName(j.getJobName());
            job.setRunDate(j.getRunDate());
            return job;
        }).collect(Collectors.toList());

        return jobList;

    }

    @Override
    public Job submitJob(JobSubmit jobSubmit) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobId(UUID.randomUUID().toString());
        jobEntity.setJobName(jobSubmit.getJobName());
        JobEntity savedJob = jobRepository.save(jobEntity);
        return buildJob(savedJob);
    }

    public Job buildJob(JobEntity jobEntity) {
        Job job = new Job();
        job.setJobId(jobEntity.getJobId());
        job.setJobName(jobEntity.getJobName());
        return job;
    }
}

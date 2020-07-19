package com.dolphin.jobbuilder.service;

import com.dolphin.jobbuilder.ms.Job;
import com.dolphin.jobbuilder.ms.JobSubmit;

import java.util.List;

public interface JobService {

    List<Job> getAllJobs();
    Job submitJob(JobSubmit jobSubmit);
}

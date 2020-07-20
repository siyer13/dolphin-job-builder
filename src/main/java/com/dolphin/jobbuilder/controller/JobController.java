package com.dolphin.jobbuilder.controller;

import com.dolphin.jobbuilder.ms.Job;
import com.dolphin.jobbuilder.ms.JobSubmit;
import com.dolphin.jobbuilder.service.JobService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
@Tag(name = "Manage Job Creation")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/submit_job/")
    public Job submitJob(@RequestBody JobSubmit jobSubmit) throws ParseException { return jobService.submitJob(jobSubmit);}
}

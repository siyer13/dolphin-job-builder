package com.dolphin.jobbuilder.ms;

import lombok.Data;

import java.util.Date;

@Data
public class Job {

    private String jobId;
    private String jobName;
    private Date runDate;
}

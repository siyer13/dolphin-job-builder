package com.dolphin.jobbuilder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "run_date")
    private Date runDate;
}
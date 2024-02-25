package com.embarkx.jobms.job.dto;

import com.embarkx.jobms.job.Job;
import com.embarkx.jobms.job.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {
    private Job job;
    private Company company;
}

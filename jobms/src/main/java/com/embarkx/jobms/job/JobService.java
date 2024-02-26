package com.embarkx.jobms.job;

import com.embarkx.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> findAll();
    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean deleteById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}

package com.embarkx.jobms.job.dto;

import com.embarkx.jobms.job.external.Company;
import com.embarkx.jobms.job.external.Review;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    private Company company;
    private List<Review> reviews;
}

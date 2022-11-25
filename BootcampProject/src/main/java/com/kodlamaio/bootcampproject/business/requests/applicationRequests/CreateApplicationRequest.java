package com.kodlamaio.bootcampproject.business.requests.applicationRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {

    @Min(1)
    private int applicantId;
    @Min(1)
    private int bootcampId;

}

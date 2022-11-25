package com.kodlamaio.bootcampproject.business.requests.applicationRequests;

import com.kodlamaio.bootcampproject.business.enums.ApplicationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequests {
    @Min(1)
    private int id;
    @Min(1)
    private int applicantId;
    @Min(1)
    private int bootcampId;
    private ApplicationState applicationState;
}

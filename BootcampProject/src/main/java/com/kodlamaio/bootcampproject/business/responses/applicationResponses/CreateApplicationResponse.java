package com.kodlamaio.bootcampproject.business.responses.applicationResponses;

import com.kodlamaio.bootcampproject.business.enums.ApplicationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private ApplicationState applicationState;
}

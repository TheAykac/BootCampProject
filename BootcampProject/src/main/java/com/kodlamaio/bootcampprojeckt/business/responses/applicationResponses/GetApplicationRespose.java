package com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses;

import com.kodlamaio.bootcampprojeckt.business.enums.ApplicationState;
import com.kodlamaio.bootcampprojeckt.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicationRespose {

    private int id;
    private String name;
    private int UserId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BootcampState bootcampState;
    private ApplicationState applicationState;
}

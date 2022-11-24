package com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests;

import com.kodlamaio.bootcampprojeckt.business.enums.ApplicationState;
import com.kodlamaio.bootcampprojeckt.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {

    private String name;
    private int UserId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private BootcampState bootcampState;
    private ApplicationState applicationState;
}

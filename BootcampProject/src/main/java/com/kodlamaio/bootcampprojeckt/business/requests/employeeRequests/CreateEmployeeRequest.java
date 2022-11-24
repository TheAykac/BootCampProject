package com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;
    private String nationalIdentity;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}

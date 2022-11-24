package com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;

    private String nationalIdentity;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}

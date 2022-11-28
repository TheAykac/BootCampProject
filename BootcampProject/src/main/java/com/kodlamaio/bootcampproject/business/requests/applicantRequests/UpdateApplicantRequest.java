package com.kodlamaio.bootcampproject.business.requests.applicantRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;
    @Size(min = 11, max = 11)
    private String nationalIdentity;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}

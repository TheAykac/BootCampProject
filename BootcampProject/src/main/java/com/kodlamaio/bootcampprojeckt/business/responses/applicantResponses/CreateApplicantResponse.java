package com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String about;
    private String nationalIdentity;
    private LocalDate dateOfBirth;
}

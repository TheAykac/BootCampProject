package com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
    private String nationalIdentity;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}


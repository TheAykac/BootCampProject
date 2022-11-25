package com.kodlamaio.bootcampproject.business.requests.instructorRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}


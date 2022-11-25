package com.kodlamaio.bootcampproject.business.requests.employeeRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
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
    @Size(min = 11, max = 11)
    private String nationalIdentity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}

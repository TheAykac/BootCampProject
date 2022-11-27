package com.kodlamaio.bootcampproject.business.requests.applicantRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {


    @Min(1)
    @NotNull
    private int id;
    @Size(min = 2)
    @NotBlank
    private String firstName;
    @Size(min = 2)
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String password;
    @Size(min = 10)
    @NotBlank
    private String about;
    @Size(min = 11, max = 11)
    private String nationalIdentity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}

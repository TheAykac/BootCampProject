package com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;
}

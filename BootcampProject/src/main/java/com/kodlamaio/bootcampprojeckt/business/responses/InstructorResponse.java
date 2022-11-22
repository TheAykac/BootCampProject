package com.kodlamaio.bootcampprojeckt.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String companyName;


}

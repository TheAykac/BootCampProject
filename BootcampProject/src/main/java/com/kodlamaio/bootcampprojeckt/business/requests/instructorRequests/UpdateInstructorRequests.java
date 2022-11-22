package com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  UpdateInstructorRequests{


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
}


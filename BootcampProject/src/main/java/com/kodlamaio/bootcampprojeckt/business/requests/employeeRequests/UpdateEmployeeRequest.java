package com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;
}


package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.EmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse add(EmployeeRequest employeeRequest);
    EmployeeResponse delete (int id);
    EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);
}

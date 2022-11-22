package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.EmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAll();
    EmployeeResponse add(EmployeeRequest employeeRequest);
    EmployeeResponse delete (int id);
    EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);
}

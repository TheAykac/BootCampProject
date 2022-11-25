package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface EmployeeService {

    DataResult<List<CreateEmployeeResponse>> getAll();

    DataResult<GetEmployeeResponse> getById(int id);

    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

    Result delete(int id);

    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
}

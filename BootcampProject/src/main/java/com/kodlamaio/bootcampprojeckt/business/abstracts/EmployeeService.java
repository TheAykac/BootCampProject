package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;

import java.util.List;

public interface EmployeeService {

    DataResult<List<CreateEmployeeResponse>> getAll();

    DataResult<GetEmployeeResponse> getById(int id);

    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

    Result delete(int id);

    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
}

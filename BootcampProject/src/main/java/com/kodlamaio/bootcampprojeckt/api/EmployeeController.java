package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping()
    public DataResult<List<CreateEmployeeResponse>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping()
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        return this.employeeService.add(createEmployeeRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.employeeService.delete(id);
    }

    @PutMapping()
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/{id}")
    public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
        return this.employeeService.getById(id);
    }


}

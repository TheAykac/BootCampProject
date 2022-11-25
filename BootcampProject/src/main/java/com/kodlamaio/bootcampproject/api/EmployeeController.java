package com.kodlamaio.bootcampproject.api;

import com.kodlamaio.bootcampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public DataResult<CreateEmployeeResponse> add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {
        return this.employeeService.add(createEmployeeRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.employeeService.delete(id);
    }

    @PutMapping()
    public DataResult<UpdateEmployeeResponse> update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/{id}")
    public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
        return this.employeeService.getById(id);
    }


}

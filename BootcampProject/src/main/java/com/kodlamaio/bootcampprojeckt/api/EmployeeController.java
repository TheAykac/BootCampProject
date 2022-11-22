package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.EmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeResponse add(EmployeeRequest employeeRequest) {
        return this.employeeService.add(employeeRequest);
    }
    @DeleteMapping("/delete")
    public EmployeeResponse delete (int id) {
        return this.employeeService.delete(id);
    }

    @PutMapping("/update")
    public EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);
    }



}

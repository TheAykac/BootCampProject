package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.EmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.EmployeeResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.dataAccess.EmployeeDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private ModelMapperService modelMapperService;

    @Override
    public EmployeeResponse add(EmployeeRequest employeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(employeeRequest,Employee.class);
        this.employeeDao.save(employee);

        EmployeeResponse employeeResponse = this.modelMapperService.forDto().map(employee,EmployeeResponse.class);
        return employeeResponse;
    }

    @Override
    public EmployeeResponse delete(int id) {
        Employee employee = this.employeeDao.findById(id).get();
        this.employeeDao.deleteById(id);
        EmployeeResponse employeeResponse= this.modelMapperService.forDto().map(employee,EmployeeResponse.class);
        return employeeResponse;
    }

    @Override
    public EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);

        this.employeeDao.save(employee);

        EmployeeResponse employeeResponse = this.modelMapperService.forDto().map(employee,EmployeeResponse.class);
        return employeeResponse;
    }
}

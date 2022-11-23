package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampprojeckt.dataAccess.EmployeeDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<CreateEmployeeResponse>> getAll() {
        List<Employee> employees = this.employeeDao.findAll();
        List<CreateEmployeeResponse> createEmployeeRespons = employees.stream().map(employee -> this.modelMapperService.forDto().map(employee, CreateEmployeeResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CreateEmployeeResponse>>(createEmployeeRespons, Messages.GlobalMessage.DataListed);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        Employee employee = this.employeeDao.findById(id).get();

        GetEmployeeResponse getEmployeeResponse =
                this.modelMapperService.forDto()
                        .map(employee, GetEmployeeResponse.class);

        return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse);
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeDao.save(employee);

        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forDto().map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse,Messages.GlobalMessage.DataListed);
    }

    @Override
    public Result delete(int id) {
        Employee employee = this.employeeDao.findById(id).get();
        this.employeeDao.deleteById(id);
        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forDto().map(employee, CreateEmployeeResponse.class);
        return new SuccessResult(Messages.GlobalMessage.DataDeleted);
    }

    @Override
    public DataResult<UpdateEmployeeResponse>  update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);

        this.employeeDao.save(employee);

        UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forDto().map(employee, UpdateEmployeeResponse.class);
        return new SuccessDataResult<>(updateEmployeeResponse,Messages.GlobalMessage.DataUpdated);
    }
}

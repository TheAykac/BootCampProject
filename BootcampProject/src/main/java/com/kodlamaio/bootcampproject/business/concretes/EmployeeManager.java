package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.employeeRequests.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.employeeRequests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.employeeResponses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.result.*;
import com.kodlamaio.bootcampproject.dataAccess.EmployeeDao;
import com.kodlamaio.bootcampproject.entities.concretes.Employee;
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
        try {
            checkIfExistsById(id);
            Employee employee = this.employeeDao.findById(id).get();
            GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forDto().map(employee, GetEmployeeResponse.class);
            return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        try {
            checkIfExistsByNationalIdentity(createEmployeeRequest.getNationalIdentity());
            Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
            this.employeeDao.save(employee);
            CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forDto().map(employee, CreateEmployeeResponse.class);
            return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public Result delete(int id) {
        try {
            checkIfExistsById(id);
            Employee employee = this.employeeDao.findById(id).get();
            this.employeeDao.deleteById(id);
            CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forDto().map(employee, CreateEmployeeResponse.class);
            return new SuccessResult(Messages.GlobalMessage.DataDeleted);
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }

    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        try {
            checkIfExistsById(updateEmployeeRequest.getId());
            Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
            this.employeeDao.save(employee);
            UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forDto().map(employee, UpdateEmployeeResponse.class);
            return new SuccessDataResult<>(updateEmployeeResponse, Messages.GlobalMessage.DataUpdated);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    private void checkIfExistsByNationalIdentity(String nationalIdentity) throws BusinessException {
        if (this.employeeDao.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Employee.EmployeeNationalIdentityNotFound + nationalIdentity);
        }
    }

    private void checkIfExistsById(int id) throws BusinessException {
        if (!this.employeeDao.existsById(id)) {
            throw new BusinessException(Messages.Employee.EmployeeIdNotFound + id);

        }
    }
}

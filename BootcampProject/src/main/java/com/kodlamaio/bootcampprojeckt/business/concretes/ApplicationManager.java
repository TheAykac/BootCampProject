package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.*;
import com.kodlamaio.bootcampprojeckt.dataAccess.ApplicationDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationDao applicationDao;
    private ModelMapperService modelMapperService;


    @Override
    public Result delete(int id) {
        try {
            checkIfExistsById(id);
            this.applicationDao.deleteById(id);
            return new SuccessResult(Messages.GlobalMessage.DataDeleted);
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }

    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
        try {
            Application application = this.modelMapperService.forRequest().map(createApplicationRequest, Application.class);
            this.applicationDao.save(application);
            CreateApplicationResponse createApplicationResponse = this.modelMapperService.forDto().map(application, CreateApplicationResponse.class);
            return new SuccessDataResult<>(createApplicationResponse, Messages.GlobalMessage.DataCreated);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<List<GetAllApplicationRespose>> getAll() {
        try {
            List<Application> applications = this.applicationDao.findAll();
            List<GetAllApplicationRespose> getApplicationsResposes = applications.stream().map(application1 -> this.modelMapperService.forDto().map(application1, GetAllApplicationRespose.class)).collect(Collectors.toList());
            return new SuccessDataResult<List<GetAllApplicationRespose>>(getApplicationsResposes, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<GetApplicationRespose> getById(int id) {
        try {
            checkIfExistsById(id);
            Application application = this.applicationDao.getById(id);
            GetApplicationRespose getApplicationRespose = this.modelMapperService.forDto().map(application, GetApplicationRespose.class);
            return new SuccessDataResult<>(getApplicationRespose, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequests updateApplicationRequests) {
        Application application = this.modelMapperService.forRequest().map(updateApplicationRequests, Application.class);
        this.applicationDao.save(application);
        UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forDto().map(application, UpdateApplicationResponse.class);
        return new SuccessDataResult<>(updateApplicationResponse, Messages.GlobalMessage.DataUpdated);
    }

    private void checkIfExistsById(int id) throws BusinessException {
        if (!this.applicationDao.existsById(id)) {
            throw new BusinessException(Messages.Application.ApplicationIdNotFoud + id);
        }
    }
}


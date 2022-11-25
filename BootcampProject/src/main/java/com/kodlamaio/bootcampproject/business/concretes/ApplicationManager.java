package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampproject.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampproject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampproject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.ApplicationDao;
import com.kodlamaio.bootcampproject.entities.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationDao applicationDao;
    private ModelMapperService modelMapperService;
    private ApplicantService applicantService;
    private BootcampService bootcampService;
    private BlackListService blackListService;


    @Override
    public Result delete(int id) {

        checkIfExistsById(id);
        this.applicationDao.deleteById(id);
        return new SuccessResult(Messages.GlobalMessage.DataDeleted);


    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
        this.blackListService.checkIfNotExistsByApplicantId(createApplicationRequest.getApplicantId());
        this.applicantService.checkIfExistsByApplicantId(createApplicationRequest.getApplicantId());
        this.bootcampService.checkIfExistByBootcampId(createApplicationRequest.getBootcampId());
        Application application = this.modelMapperService.forRequest().map(createApplicationRequest, Application.class);
        this.applicationDao.save(application);
        CreateApplicationResponse createApplicationResponse = this.modelMapperService.forDto().map(application, CreateApplicationResponse.class);
        return new SuccessDataResult<>(createApplicationResponse, Messages.GlobalMessage.DataCreated);


    }

    @Override
    public DataResult<List<GetAllApplicationRespose>> getAll() {
        List<Application> applications = this.applicationDao.findAll();
        List<GetAllApplicationRespose> getApplicationsResposes = applications.stream().map(application1 -> this.modelMapperService.forDto().map(application1, GetAllApplicationRespose.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationRespose>>(getApplicationsResposes, Messages.GlobalMessage.DataListed);


    }

    @Override
    public DataResult<GetApplicationRespose> getById(int id) {
        checkIfExistsById(id);
        Application application = this.applicationDao.getById(id);
        GetApplicationRespose getApplicationRespose = this.modelMapperService.forDto().map(application, GetApplicationRespose.class);
        return new SuccessDataResult<>(getApplicationRespose, Messages.GlobalMessage.DataListed);


    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequests updateApplicationRequests) {
        this.applicantService.checkIfExistsByApplicantId(updateApplicationRequests.getApplicantId());
        this.bootcampService.checkIfExistByBootcampId(updateApplicationRequests.getBootcampId());
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




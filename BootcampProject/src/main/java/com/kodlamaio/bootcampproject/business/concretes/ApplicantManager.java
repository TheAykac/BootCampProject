package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.ApplicantDao;
import com.kodlamaio.bootcampproject.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantDao applicantDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = this.applicantDao.findAll();
        List<GetAllApplicantResponse> getAllApplicantResponses = applicants.stream().map(applicant -> this.modelMapperService.forRequest().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicantResponse>>(getAllApplicantResponses, Messages.GlobalMessage.DataListed);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant applicant = this.applicantDao.findById(id).get();
        GetApplicantResponse getApplicantResponse = this.modelMapperService.forDto().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse, Messages.GlobalMessage.DataListed);

    }

    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
        checkIfExistsByNationalIdentity(createApplicantRequest.getNationalIdentity());
        Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
        this.applicantDao.save(applicant);
        CreateApplicantResponse createApplicantResponse = this.modelMapperService.forRequest().map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse, Messages.GlobalMessage.DataCreated);

    }

    @Override
    public Result delete(int id) {
        checkIfExistsByApplicantId(id);
        this.applicantDao.deleteById(id);
        return new SuccessResult(Messages.GlobalMessage.DataDeleted);
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        this.applicantDao.save(applicant);
        UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forDto().map(applicant, UpdateApplicantResponse.class);
        return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.GlobalMessage.DataUpdated);

    }

    private void checkIfExistsByNationalIdentity(String nationalIdentity) throws BusinessException {
        if (this.applicantDao.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Applicant.ApplicantNationalIdentityNotFound + nationalIdentity);
        }
    }

    @Override
    public void checkIfExistsByApplicantId(int id) throws BusinessException {
        if (!this.applicantDao.existsById(id)) {
            throw new BusinessException(Messages.Applicant.ApplicantIdNotFound + id);
        }

    }
}

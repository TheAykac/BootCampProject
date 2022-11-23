package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampprojeckt.dataAccess.ApplicantDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Applicant;
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
        return new SuccessDataResult<List<GetAllApplicantResponse>>(getAllApplicantResponses,Messages.GlobalMessage.DataListed);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant applicant = this.applicantDao.findById(id).get();
        GetApplicantResponse getApplicantResponse = this.modelMapperService.forDto().map(applicant,GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse,Messages.GlobalMessage.DataListed);

    }

    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest,Applicant.class);
        this.applicantDao.save(applicant);

        CreateApplicantResponse createApplicantResponse = this.modelMapperService.forRequest().map(applicant,CreateApplicantResponse.class);

        return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse,Messages.GlobalMessage.DataCreated);
    }

    @Override
    public Result delete(int id) {

       this.applicantDao.deleteById(id);
       return new SuccessResult(Messages.GlobalMessage.DataDeleted);
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {

        Applicant applicant =this.modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
        this.applicantDao.save(applicant);

        UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forDto().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse,Messages.GlobalMessage.DataUpdated);
    }
}

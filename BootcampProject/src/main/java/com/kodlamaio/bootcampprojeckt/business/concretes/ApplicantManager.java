package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.ApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.ApplicantResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
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
    public List<ApplicantResponse> getAll() {
        List<Applicant> applicants = this.applicantDao.findAll();
        List<ApplicantResponse> applicantResponses = applicants.stream().map(applicant -> this.modelMapperService.forDto().map(applicant,ApplicantResponse.class)).collect(Collectors.toList());
        return applicantResponses;
    }

    @Override
    public ApplicantResponse add(ApplicantRequest applicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(applicantRequest,Applicant.class);
        this.applicantDao.save(applicant);

        ApplicantResponse applicantResponse= this.modelMapperService.forDto().map(applicant,ApplicantResponse.class);

        return applicantResponse;
    }

    @Override
    public ApplicantResponse delete(int id) {

        Applicant applicant=this.applicantDao.findById(id).get();

        ApplicantResponse applicantResponse=this.modelMapperService.forDto().map(applicant,ApplicantResponse.class);
        return applicantResponse;
    }

    @Override
    public ApplicantResponse update(UpdateApplicantRequest updateApplicantRequest) {

        Applicant applicant =this.modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
        this.applicantDao.save(applicant);

        ApplicantResponse applicantResponse = this.modelMapperService.forDto().map(applicant,ApplicantResponse.class);

        return applicantResponse;
    }
}

package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.ApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.ApplicantResponse;

public interface ApplicantService {

    ApplicantResponse add (ApplicantRequest applicantRequest);
    ApplicantResponse delete(int id);
    ApplicantResponse update(UpdateApplicantRequest updateApplicantRequest);
}

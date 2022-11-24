package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;

import java.util.List;

public interface ApplicantService {

    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<GetApplicantResponse> getById(int id);

    DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

    Result delete(int id);

    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
}

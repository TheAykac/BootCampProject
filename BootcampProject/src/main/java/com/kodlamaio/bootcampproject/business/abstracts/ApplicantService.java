package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface ApplicantService {

    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<GetApplicantResponse> getById(int id);

    DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

    Result delete(int id);

    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);


    void checkIfExistsByApplicantId(int id) throws BusinessException;
}

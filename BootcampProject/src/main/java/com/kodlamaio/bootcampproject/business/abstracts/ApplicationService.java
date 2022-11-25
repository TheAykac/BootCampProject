package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface ApplicationService {

    Result delete(int id);

    DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

    DataResult<List<GetAllApplicationRespose>> getAll();

    DataResult<GetApplicationRespose> getById(int id);

    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequests updateApplicationRequests);
}

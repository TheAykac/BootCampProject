package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;

import java.util.List;

public interface ApplicationService {

    Result delete(int id);

    DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

    DataResult<List<GetAllApplicationRespose>> getAll();

    DataResult<GetApplicationRespose> getById(int id);

    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequests updateApplicationRequests);
}

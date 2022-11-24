package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;

import java.util.List;

public interface BootcampService {

    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);

    DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);
    DataResult<UpdateBootcampResponse> update (UpdateBootcampRequest updateBootcampRequest);
    Result delete(int id);

}

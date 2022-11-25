package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface BootcampService {

    DataResult<List<GetAllBootcampResponse>> getAll();

    DataResult<GetBootcampResponse> getById(int id);

    DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);

    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);

    Result delete(int id);

    void checkIfExistByBootcampId(int id) throws BusinessException;
}

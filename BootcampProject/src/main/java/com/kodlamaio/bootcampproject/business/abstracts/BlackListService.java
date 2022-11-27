package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.blackListRequests.CreateBlackListRequest;
import com.kodlamaio.bootcampproject.business.requests.blackListRequests.UpdateBlackListRequest;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.CreateBlackListRespose;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetAllBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.UpdateBlackListResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface BlackListService {

    DataResult<CreateBlackListRespose> add(CreateBlackListRequest createBlackListRequest);

    DataResult<List<GetAllBlackListResponse>> getAll();

    DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);

    DataResult<GetBlackListResponse> getById(int id);

    Result delete(int id);

    void checkIfExistsById(int id);

    void checkIfNotExistsByApplicantId(int id);

}

package com.kodlamaio.bootcampproject.business.abstracts;

import com.kodlamaio.bootcampproject.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootcampproject.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootcampproject.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.instructorResponses.GetAllInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorResponse>> getAll();

    DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);

    Result delete(int id);

    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);

    DataResult<GetInstructorResponse> getById(int id);


    void checkIfExistsByInstructorId(int id) throws BusinessException;
}

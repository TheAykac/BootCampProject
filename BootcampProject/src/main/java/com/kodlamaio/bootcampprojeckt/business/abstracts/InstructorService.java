package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.*;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<CreateInstructorResponse>add(CreateInstructorRequest createInstructorRequest);
    Result delete(int id);
    DataResult<UpdateInstructorResponse>update(UpdateInstructorRequest updateInstructorRequest);
    DataResult<GetInstructorResponse> getById(int id);



}

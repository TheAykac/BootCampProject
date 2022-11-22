package com.kodlamaio.bootcampprojeckt.business.abstracts;

import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.InstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.InstructorResponse;

public interface InstructorService {
    InstructorResponse add (InstructorRequest instructorRequest);
    InstructorResponse delete (int id);
    InstructorResponse update (UpdateInstructorRequests updateInstructorRequests);
}

package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.InstructorService;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.InstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.InstructorResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.dataAccess.InstructorDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorDao instructorDao;
    private ModelMapperService modelMapperService;

    @Override
    public InstructorResponse add(InstructorRequest instructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(instructorRequest,Instructor.class);
        this.instructorDao.save(instructor);

        InstructorResponse instructorResponse = this.modelMapperService.forDto().map(instructor,InstructorResponse.class);
        return instructorResponse;
    }

    @Override
    public InstructorResponse delete(int id) {
        Instructor instructor = this.instructorDao.findById(id).get();
        this.instructorDao.deleteById(id);

        InstructorResponse instructorResponse = this.modelMapperService.forDto().map(instructor,InstructorResponse.class);
        return instructorResponse;
    }

    @Override
    public InstructorResponse update(UpdateInstructorRequests updateInstructorRequests) {
        Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequests,Instructor.class);

        this.instructorDao.save(instructor);

        InstructorResponse instructorResponse = this.modelMapperService.forDto().map(instructor,InstructorResponse.class);
        return instructorResponse;
    }
}

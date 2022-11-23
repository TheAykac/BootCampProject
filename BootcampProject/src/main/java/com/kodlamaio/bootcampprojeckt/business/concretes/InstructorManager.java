package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.InstructorService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.*;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampprojeckt.dataAccess.InstructorDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

    private InstructorDao instructorDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = this.instructorDao.findAll();
        List<GetAllInstructorResponse> getAllInstructorResponses = instructors.stream().map(instructor -> this.modelMapperService.forDto().map(instructor,GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(getAllInstructorResponses, Messages.GlobalMessage.DataListed);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);
        this.instructorDao.save(instructor);

        CreateInstructorResponse createInstructorResponse = this.modelMapperService.forDto().map(instructor,CreateInstructorResponse.class);
        return new SuccessDataResult<>(createInstructorResponse, Messages.GlobalMessage.DataListed);
    }

    @Override
    public Result delete(int id) {
        Instructor instructor = this.instructorDao.findById(id).get();
        this.instructorDao.deleteById(id);
        return new SuccessResult(Messages.GlobalMessage.DataListed);
    }

    @Override
    public  DataResult<UpdateInstructorResponse>update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);

        this.instructorDao.save(instructor);

        UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forDto().map(instructor,UpdateInstructorResponse.class);
        return new SuccessDataResult<>(updateInstructorResponse,Messages.GlobalMessage.DataUpdated);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor=this.instructorDao.findById(id).get();
        GetInstructorResponse getInstructorResponse=this.modelMapperService.forDto().map(instructor,GetInstructorResponse.class);

        return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse,Messages.GlobalMessage.DataListed);
    }
}

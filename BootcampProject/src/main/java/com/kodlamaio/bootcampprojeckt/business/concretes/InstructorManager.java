package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.InstructorService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.GetAllInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.*;
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
        List<GetAllInstructorResponse> getAllInstructorResponses = instructors.stream().map(instructor -> this.modelMapperService.forDto().map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(getAllInstructorResponses, Messages.GlobalMessage.DataListed);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
        checkIfExistsByNationalIdentity(createInstructorRequest.getNationalIdentity());
        Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
        this.instructorDao.save(instructor);

        CreateInstructorResponse createInstructorResponse = this.modelMapperService.forDto().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<>(createInstructorResponse, Messages.GlobalMessage.DataListed);
    }

    @Override
    public Result delete(int id) {
        try {
            checkIfExistsById(id);
            Instructor instructor = this.instructorDao.findById(id).get();
            this.instructorDao.deleteById(id);
            return new SuccessResult(Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }

    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
        try {
            checkIfExistsById(updateInstructorRequest.getId());
            Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
            this.instructorDao.save(instructor);
            UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forDto().map(instructor, UpdateInstructorResponse.class);
            return new SuccessDataResult<>(updateInstructorResponse, Messages.GlobalMessage.DataUpdated);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        try {
            checkIfExistsById(id);
            Instructor instructor = this.instructorDao.findById(id).get();
            GetInstructorResponse getInstructorResponse = this.modelMapperService.forDto().map(instructor, GetInstructorResponse.class);
            return new SuccessDataResult<GetInstructorResponse>(getInstructorResponse, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    private void checkIfExistsByNationalIdentity(String nationalIdentity) throws BusinessException {
        if (this.instructorDao.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Instructor.InstructorNationalIdentityNotFound + nationalIdentity);
        }
    }

    private void checkIfExistsById(int id) throws BusinessException {
        if (!this.instructorDao.existsById(id)) {
            throw new BusinessException(Messages.Instructor.InstructorIdNotFound + id);
        }
    }
}


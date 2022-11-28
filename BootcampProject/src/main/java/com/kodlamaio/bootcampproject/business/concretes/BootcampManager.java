package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampproject.business.abstracts.InstructorService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.BootcampDao;
import com.kodlamaio.bootcampproject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampDao bootcampDao;
    private ModelMapperService modelMapperService;
    private InstructorService instructorService;

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = this.bootcampDao.findAll();
        List<GetAllBootcampResponse> getAllBootcampResponses = bootcamps.stream().map(bootcamp -> this.modelMapperService.forDto().map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllBootcampResponses, Messages.GlobalMessage.DataListed);

    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        checkIfExistByBootcampId(id);
        Bootcamp bootcamp = this.bootcampDao.getById(id);
        GetBootcampResponse getBootcampResponse = this.modelMapperService.forDto().map(bootcamp, GetBootcampResponse.class);
        return new SuccessDataResult<>(getBootcampResponse, Messages.GlobalMessage.DataListed);

    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
        this.instructorService.checkIfExistsByInstructorId(createBootcampRequest.getInstructorId());
        checkIfFisrtDateBeforeSecondDate(createBootcampRequest.getStartDate(), createBootcampRequest.getEndDate());
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
        bootcamp.setId(0);
        this.bootcampDao.save(bootcamp);
        CreateBootcampResponse createBootcampResponse = this.modelMapperService.forDto().map(bootcamp, CreateBootcampResponse.class);
        return new SuccessDataResult<>(createBootcampResponse, Messages.GlobalMessage.DataCreated);


    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        this.instructorService.checkIfExistsByInstructorId(updateBootcampRequest.getInstructorId());
        checkIfFisrtDateBeforeSecondDate(updateBootcampRequest.getStartDate(), updateBootcampRequest.getEndDate());
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        this.bootcampDao.save(bootcamp);
        UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forDto().map(bootcamp, UpdateBootcampResponse.class);
        return new SuccessDataResult<>(updateBootcampResponse, Messages.GlobalMessage.DataUpdated);

    }

    @Override
    public Result delete(int id) {
        checkIfExistByBootcampId(id);
        this.bootcampDao.deleteById(id);
        return new SuccessResult(Messages.GlobalMessage.DataDeleted);

    }

    @Override
    public void checkIfExistByBootcampId(int id) throws BusinessException {
        if (!this.bootcampDao.existsById(id)) {
            throw new BusinessException(Messages.BootCamp.BootcampIdNotFoud + id);
        }
    }

    private void checkIfFisrtDateBeforeSecondDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate) || startDate.equals(endDate)) {
            throw new BusinessException(Messages.BootCamp.FINISH_DATE_CANNOT_BEFORE_START_DATE);
        }
    }

    private void checkIfSameBootcampApplicationExists(int applicantId,int bootcampId){

    }

}




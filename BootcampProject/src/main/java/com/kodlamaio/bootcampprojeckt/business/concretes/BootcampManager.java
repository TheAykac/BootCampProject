package com.kodlamaio.bootcampprojeckt.business.concretes;

import com.kodlamaio.bootcampprojeckt.business.abstracts.BootcampService;
import com.kodlamaio.bootcampprojeckt.business.constants.Messages;
import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampprojeckt.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.*;
import com.kodlamaio.bootcampprojeckt.dataAccess.BootcampDao;
import com.kodlamaio.bootcampprojeckt.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampDao bootcampDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        try {
            List<Bootcamp> bootcamps = this.bootcampDao.findAll();
            List<GetAllBootcampResponse> getAllBootcampResponses = bootcamps.stream().map(bootcamp -> this.modelMapperService.forDto().map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());
            return new SuccessDataResult<>(getAllBootcampResponses, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());

        }

    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        try {
            Bootcamp bootcamp = this.bootcampDao.getById(id);
            GetBootcampResponse getBootcampResponse = this.modelMapperService.forDto().map(bootcamp, GetBootcampResponse.class);
            return new SuccessDataResult<>(getBootcampResponse, Messages.GlobalMessage.DataListed);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
        try {
            Bootcamp bootcamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
            this.bootcampDao.save(bootcamp);
            CreateBootcampResponse createBootcampResponse = this.modelMapperService.forDto().map(bootcamp, CreateBootcampResponse.class);
            return new SuccessDataResult<>(createBootcampResponse, Messages.GlobalMessage.DataCreated);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        try {
            Bootcamp bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
            this.bootcampDao.save(bootcamp);
            UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forDto().map(bootcamp, UpdateBootcampResponse.class);
            return new SuccessDataResult<>(updateBootcampResponse, Messages.GlobalMessage.DataUpdated);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result delete(int id) {
        try {
            checkIfExistById(id);
            this.bootcampDao.deleteById(id);
            return new SuccessResult(Messages.GlobalMessage.DataDeleted);
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());

        }
    }

    private void checkIfExistById(int id) throws BusinessException {
        if (!this.bootcampDao.existsById(id)) {
            throw new BusinessException(Messages.BootCamp.BootcampIdNotFoud + id);
        }
    }
}

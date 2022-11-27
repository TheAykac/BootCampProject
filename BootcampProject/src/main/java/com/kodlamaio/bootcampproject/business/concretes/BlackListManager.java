package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampproject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.blackListRequests.CreateBlackListRequest;
import com.kodlamaio.bootcampproject.business.requests.blackListRequests.UpdateBlackListRequest;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.CreateBlackListRespose;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetAllBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.UpdateBlackListResponse;
import com.kodlamaio.bootcampproject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.BlackListDao;
import com.kodlamaio.bootcampproject.entities.concretes.BlackList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {

    private ModelMapperService modelMapperService;
    private BlackListDao blackListDao;
    private ApplicantService applicantService;

    @Override
    public DataResult<CreateBlackListRespose> add(CreateBlackListRequest createBlackListRequest) {
        this.applicantService.checkIfExistsByApplicantId(createBlackListRequest.getApplicantId());
        BlackList blackList = this.modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
        this.blackListDao.save(blackList);
        CreateBlackListRespose createBlackListRespose = this.modelMapperService.forDto().map(blackList, CreateBlackListRespose.class);
        return new SuccessDataResult<>(createBlackListRespose, Messages.GlobalMessage.DataCreated);

    }

    @Override
    public DataResult<List<GetAllBlackListResponse>> getAll() {
        List<BlackList> blackLists = this.blackListDao.findAll();
        List<GetAllBlackListResponse> getAllBlackListResponses = blackLists.stream().map(blackList -> this.modelMapperService.forDto().map(blackList, GetAllBlackListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(getAllBlackListResponses, Messages.GlobalMessage.DataListed);

    }

    @Override
    public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
        this.applicantService.checkIfExistsByApplicantId(updateBlackListRequest.getApplicantId());
        BlackList blackList = this.modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
        this.blackListDao.save(blackList);
        UpdateBlackListResponse updateBlackListResponse = this.modelMapperService.forDto().map(blackList, UpdateBlackListResponse.class);
        return new SuccessDataResult<>(updateBlackListResponse, Messages.GlobalMessage.DataUpdated);

    }

    @Override
    public DataResult<GetBlackListResponse> getById(int id) {
        checkIfExistsById(id);
        BlackList blackList = this.blackListDao.getById(id);
        GetBlackListResponse getBlackListResponse = this.modelMapperService.forDto().map(blackList, GetBlackListResponse.class);
        return new SuccessDataResult<>(getBlackListResponse, Messages.GlobalMessage.DataListed);

    }

    @Override
    public Result delete(int id) {
        checkIfExistsById(id);
        this.blackListDao.deleteById(id);
        return new SuccessResult(Messages.GlobalMessage.DataDeleted);
    }

    @Override
    public void checkIfExistsById(int id) {
        if (!this.blackListDao.existsById(id)) {
            throw new BusinessException(Messages.BlackList.BlackListIdNotFound + id);
        }
    }

    @Override
    public void checkIfNotExistsByApplicantId(int id) {
        if (this.blackListDao.existsByApplicantId(id)) {
            throw new BusinessException(Messages.BlackList.BlackListIdAlreadyExists + id);
        }
    }
}

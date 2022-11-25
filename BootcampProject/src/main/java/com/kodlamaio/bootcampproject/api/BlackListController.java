package com.kodlamaio.bootcampproject.api;

import com.kodlamaio.bootcampproject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampproject.business.requests.blackListRequests.CreateBlackListRequest;
import com.kodlamaio.bootcampproject.business.requests.blackListRequests.UpdateBlackListRequest;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.CreateBlackListRespose;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetAllBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.GetBlackListResponse;
import com.kodlamaio.bootcampproject.business.responses.blackListResponses.UpdateBlackListResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blacklist")
@AllArgsConstructor
public class BlackListController {
    private BlackListService blackListService;

    @PostMapping
    public DataResult<CreateBlackListRespose> add(@RequestBody @Valid CreateBlackListRequest createBlackListRequest) {
        return this.blackListService.add(createBlackListRequest);
    }

    @GetMapping()
    public DataResult<List<GetAllBlackListResponse>> getAll() {
        return this.blackListService.getAll();
    }

    @PutMapping
    public DataResult<UpdateBlackListResponse> update(@RequestBody @Valid UpdateBlackListRequest updateBlackListRequest) {
        return this.blackListService.update(updateBlackListRequest);
    }

    @GetMapping("{id}")
    public DataResult<GetBlackListResponse> getById(@PathVariable int id) {
        return this.blackListService.getById(id);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return this.blackListService.delete(id);
    }


}

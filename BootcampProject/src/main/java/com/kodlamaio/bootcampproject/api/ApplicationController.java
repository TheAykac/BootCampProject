package com.kodlamaio.bootcampproject.api;

import com.kodlamaio.bootcampproject.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampproject.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampproject.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/application")
@AllArgsConstructor
public class ApplicationController {
    private ApplicationService applicationService;

    @DeleteMapping("{id}")
    public Result delete(int id) {
        return this.applicationService.delete(id);
    }

    @PostMapping
    public DataResult<CreateApplicationResponse> add(@RequestBody @Valid CreateApplicationRequest createApplicationRequest) {
        return this.applicationService.add(createApplicationRequest);
    }

    @GetMapping
    public DataResult<List<GetAllApplicationRespose>> getAll() {
        return this.applicationService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<GetApplicationRespose> getById(int id) {
        return this.applicationService.getById(id);
    }

    @PutMapping()
    DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequests updateApplicationRequests) {
        return this.applicationService.update(updateApplicationRequests);
    }
}

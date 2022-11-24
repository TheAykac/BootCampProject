package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.CreateApplicationRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicationRequests.UpdateApplicationRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.CreateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetAllApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampprojeckt.business.responses.applicationResponses.UpdateApplicationResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
    private ApplicationService applicationService;

    @DeleteMapping("{id}")
    public Result delete(int id) {
        return this.applicationService.delete(id);
    }

    @PostMapping
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
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
    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequests updateApplicationRequests) {
        return this.applicationService.update(updateApplicationRequests);
    }
}

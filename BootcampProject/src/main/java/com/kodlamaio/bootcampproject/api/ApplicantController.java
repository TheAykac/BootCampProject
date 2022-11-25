package com.kodlamaio.bootcampproject.api;

import com.kodlamaio.bootcampproject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampproject.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicant")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @GetMapping()
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        return this.applicantService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
        return this.applicantService.getById(id);
    }

    @PostMapping()
    public DataResult<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest) {
        return this.applicantService.add(createApplicantRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.applicantService.delete(id);
    }

    @PutMapping()
    public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateApplicantRequest) {
        return this.applicantService.update(updateApplicantRequest);
    }

}

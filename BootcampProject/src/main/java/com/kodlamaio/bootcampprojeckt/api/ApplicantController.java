package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.CreateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.CreateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetAllApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.GetApplicantResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.applicantResponses.UpdateApplicantResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicant")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @GetMapping()
    public DataResult<List<GetAllApplicantResponse>> getAll(){
        return this.applicantService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetApplicantResponse> getById( @PathVariable int id){
        return this.applicantService.getById(id);
    }
    @PostMapping()
    public DataResult<CreateApplicantResponse> add (CreateApplicantRequest createApplicantRequest){
        return this.applicantService.add(createApplicantRequest);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.applicantService.delete(id);
    }
    @PutMapping()
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest){
        return this.applicantService.update(updateApplicantRequest);
    }

}

package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.ApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.applicantRequests.UpdateApplicantRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.ApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicant")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping("/add")
   public  ApplicantResponse add (ApplicantRequest applicantRequest){
       return this.applicantService.add(applicantRequest);
   }
   @DeleteMapping("/delete")
   public  ApplicantResponse delete(int id){
       return this.applicantService.delete(id);
   }

   @PutMapping("/update")
   public  ApplicantResponse update(UpdateApplicantRequest updateApplicantRequest){
       return this.applicantService.update(updateApplicantRequest);
   }
}

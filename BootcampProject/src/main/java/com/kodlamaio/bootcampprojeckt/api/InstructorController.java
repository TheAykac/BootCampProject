package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.InstructorService;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.InstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequests;
import com.kodlamaio.bootcampprojeckt.business.responses.InstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;

    @GetMapping("/getAll")
    public List<InstructorResponse> getAll(){
        return this.instructorService.getAll();
    }

    @PostMapping("/add")
    public InstructorResponse add (InstructorRequest instructorRequest) {
        return this.instructorService.add(instructorRequest);
    }
    @DeleteMapping("/delete")
    public InstructorResponse delete (int id) {
        return this.instructorService.delete(id);
    }

    @PutMapping("/update")
    public InstructorResponse update (UpdateInstructorRequests updateInstructorRequests) {
        return this.instructorService.update(updateInstructorRequests);
    }

}

package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.InstructorService;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.CreateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.instructorRequests.UpdateInstructorRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.CreateInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.GetAllInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.GetInstructorResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses.UpdateInstructorResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;



    @GetMapping()
    public DataResult<List<GetAllInstructorResponse>> getAll(){
        return this.instructorService.getAll();
    }
    @GetMapping("/{id}")
    public DataResult<GetInstructorResponse> getById(@PathVariable int id){
        return this.instructorService.getById(id);
    }
    @PostMapping()
    public DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest createInstructorRequest){
        return this.instructorService.add(createInstructorRequest);
    }

    @PutMapping()
    public DataResult<UpdateInstructorResponse>update(@RequestBody UpdateInstructorRequest updateInstructorRequest){
        return this.instructorService.update(updateInstructorRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.instructorService.delete(id);
    }




}

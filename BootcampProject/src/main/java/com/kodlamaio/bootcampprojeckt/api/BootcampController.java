package com.kodlamaio.bootcampprojeckt.api;

import com.kodlamaio.bootcampprojeckt.business.abstracts.BootcampService;
import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.DataResult;
import com.kodlamaio.bootcampprojeckt.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamp")
@AllArgsConstructor
public class BootcampController {
    private BootcampService bootcampService;


    @GetMapping()
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        return this.bootcampService.getAll();
    }
    @GetMapping("{id}")
    public DataResult<GetBootcampResponse> getById(int id) {
        return this.bootcampService.getById(id);
    }
    @PostMapping()
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
        return this.bootcampService.add(createBootcampRequest);
    }
    @PutMapping()
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        return this.bootcampService.update(updateBootcampRequest);
    }
    @DeleteMapping("{id}")
    public Result delete(int id) {
        return this.bootcampService.delete(id);
    }
}

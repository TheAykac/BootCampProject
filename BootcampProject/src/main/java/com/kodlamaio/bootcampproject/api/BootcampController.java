package com.kodlamaio.bootcampproject.api;

import com.kodlamaio.bootcampproject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.CreateBootcampRequest;
import com.kodlamaio.bootcampproject.business.requests.bootcampRequests.UpdateBootcampRequest;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.CreateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetAllBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.GetBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcampResponses.UpdateBootcampResponse;
import com.kodlamaio.bootcampproject.core.utilities.result.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
        return this.bootcampService.getById(id);
    }

    @PostMapping()
    public DataResult<CreateBootcampResponse> add(@RequestBody @Valid CreateBootcampRequest createBootcampRequest) {
        return this.bootcampService.add(createBootcampRequest);
    }

    @PutMapping()
    public DataResult<UpdateBootcampResponse> update(@RequestBody @Valid UpdateBootcampRequest updateBootcampRequest) {
        return this.bootcampService.update(updateBootcampRequest);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable int id) {
        return this.bootcampService.delete(id);
    }
}

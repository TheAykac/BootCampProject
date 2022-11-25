package com.kodlamaio.bootcampproject.business.requests.bootcampRequests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodlamaio.bootcampproject.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {

    @Min(1)
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private BootcampState bootcampState;
    @Min(1)
    private int instructorId;
}

package com.kodlamaio.bootcampproject.business.responses.bootcampResponses;

import com.kodlamaio.bootcampproject.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampResponse {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BootcampState bootcampState;
    private int instructorId;
}

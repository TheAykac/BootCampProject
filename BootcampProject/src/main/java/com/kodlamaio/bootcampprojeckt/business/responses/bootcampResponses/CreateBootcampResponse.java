package com.kodlamaio.bootcampprojeckt.business.responses.bootcampResponses;

import com.kodlamaio.bootcampprojeckt.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private BootcampState bootcampState;
}

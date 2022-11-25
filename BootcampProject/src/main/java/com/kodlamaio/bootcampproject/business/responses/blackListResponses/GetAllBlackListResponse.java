package com.kodlamaio.bootcampproject.business.responses.blackListResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllBlackListResponse {
    private int id;
    private int applicantId;
    private LocalDate dateOfBan;
    private String description;
}

package com.kodlamaio.bootcampprojeckt.business.responses.instructorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
}
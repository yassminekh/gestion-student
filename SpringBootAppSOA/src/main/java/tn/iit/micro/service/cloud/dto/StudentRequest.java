package tn.iit.micro.service.cloud.dto;

import lombok.Data;

@Data
public class StudentRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String street;
}

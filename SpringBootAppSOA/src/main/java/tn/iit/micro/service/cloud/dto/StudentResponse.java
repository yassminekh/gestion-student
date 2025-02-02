package tn.iit.micro.service.cloud.dto;

import lombok.Data;
import tn.iit.micro.service.cloud.entities.Student;


@Data
public class StudentResponse {
	public StudentResponse(Student student) {
		this.id = student.getId();
		this.addressId = student.getAddress().getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}
	private long id;
	private long addressId;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String street;
}

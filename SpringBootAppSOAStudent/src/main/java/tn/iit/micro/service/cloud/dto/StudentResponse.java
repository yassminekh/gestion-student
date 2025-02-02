package tn.iit.micro.service.cloud.dto;

import lombok.Data;
import tn.iit.micro.service.cloud.entities.Student;


@Data
public class StudentResponse {
	public StudentResponse(Student student,AddressResponse address) {
		this.id = student.getId();
		this.addressId=address.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.street =address.getStreet();
		this.city=address.getCity();
	
	}
	private long id;
	private long addressId;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String street;
}

package tn.iit.micro.service.cloud.dto;

import lombok.Data;

@Data
public class AddressRequest {

	private long id;
	private String city;
	private String street;
}

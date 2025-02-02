package tn.iit.micro.service.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressRequest {


	private String city;
	private String street;
}

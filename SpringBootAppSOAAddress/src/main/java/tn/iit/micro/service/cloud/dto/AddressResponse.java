package tn.iit.micro.service.cloud.dto;

import lombok.Data;
import tn.iit.micro.service.cloud.entities.Address;



@Data
public class AddressResponse {
	public AddressResponse(Address address) {
		this.id = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
	}
	private long id;
	private String city;
	private String street;
}

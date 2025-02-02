package tn.iit.micro.service.cloud.proxies;

import feign.Response;
import feign.codec.ErrorDecoder;
import tn.iit.micro.service.cloud.utils.AddressNotFoundException;


public class CustomErrorDecoder implements ErrorDecoder {
	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String invoqueur, Response reponse) {
		if (reponse.status() == 400) {
			throw new AddressNotFoundException("Requête incorrecte ");
		}
		return defaultErrorDecoder.decode(invoqueur, reponse);
	}

}

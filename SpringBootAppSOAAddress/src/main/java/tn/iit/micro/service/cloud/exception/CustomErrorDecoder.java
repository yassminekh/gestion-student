package tn.iit.micro.service.cloud.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import tn.iit.micro.service.cloud.utils.AdressBadRequestException;

public class CustomErrorDecoder implements ErrorDecoder {
	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String invoqueur, Response reponse) {
		if (reponse.status() == 400) {
			throw new AdressBadRequestException("Requête incorrecte ");
		}
		return defaultErrorDecoder.decode(invoqueur, reponse);
	}

	
}

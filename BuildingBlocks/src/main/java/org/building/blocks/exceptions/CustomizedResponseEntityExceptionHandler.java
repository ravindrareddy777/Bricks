package org.building.blocks.exceptions;

import org.building.blocks.vo.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(InvalidOrderReferenceException.class)
	public final ResponseEntity<?> handleArtifactNotFoundException(InvalidOrderReferenceException ex, WebRequest request) {
		ServiceResponse resp = getResponse(ex);
		return new ResponseEntity<ServiceResponse>(resp, HttpStatus.NOT_FOUND);
	}
	
	private ServiceResponse getResponse(InvalidOrderReferenceException ex) {
		ServiceResponse response = new ServiceResponse();
		response.setErrorCode("401");
		response.setErrorMessage("invalid orderreferenceid");
		return response;
	}
	

}

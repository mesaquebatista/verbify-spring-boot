package br.com.mesaquebatista.verbify.responses;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatusCode, Object responseObject){
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("message", message);
		responseMap.put("status", httpStatusCode.value());
		responseMap.put("data", responseObject);
		
		return new ResponseEntity<Object>(responseMap, httpStatusCode);
	}
}

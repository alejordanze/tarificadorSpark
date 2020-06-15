package main.application.models.responseModel;

import java.util.HashMap;
import java.util.Map;

public class ResponseModel {

	private Map<String, Object> response;
	
	public ResponseModel() {
		response = new HashMap<>();
	}
	
	
	public void addInformation(String theKey, Object information) {
		response.put(theKey, information)
;	}
}

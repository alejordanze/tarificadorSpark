package main.services;

import java.util.HashMap;
import java.util.Map;

import main.interactor.UploadCDR.UploadCDRBoundaryOutputPort;

public class UploadCDRPresenter implements UploadCDRBoundaryOutputPort{

	@Override
	public Map<String, Object> present(int numberCdr) {
		Map<String, Object> model = new HashMap<>();
        model.put("quantity", numberCdr);
        model.put("type", "CDR's");
        model.put("redirect", "upload");
		return model;
	}
}

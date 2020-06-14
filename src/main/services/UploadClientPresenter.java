package main.services;

import java.util.HashMap;
import java.util.Map;

import main.interactor.UploadClient.UploadClientBoundaryOutputPort;

public class UploadClientPresenter implements UploadClientBoundaryOutputPort{

	@Override
	public Map<String, Object> present(int numberCdr) {
		Map<String, Object> model = new HashMap<>();
		model.put("quantity", numberCdr);
        model.put("type", "Clientes");
        model.put("redirect", "uploadClient");
		return model;
	}

}

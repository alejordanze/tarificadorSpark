package main.services.presenters;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.UploadClient.UploadClientBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class UploadClientPresenter implements UploadClientBoundaryOutputPort{

	@Override
	public ResponseModel present(int numberCdr) {
		ResponseModel model = new ResponseModel();
		model.addInformation("quantity", numberCdr);
        model.addInformation("type", "Clientes");
        model.addInformation("redirect", "uploadClient");
		return model;
	}

}

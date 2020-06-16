package main.services.presenters;

import java.util.HashMap;
import java.util.Map;

import main.application.interactors.UploadCDR.UploadCDRBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class UploadCDRPresenter implements UploadCDRBoundaryOutputPort{

	@Override
	public ResponseModel present(int numberCdr) {
		ResponseModel model = new ResponseModel();
        model.addInformation("quantity", numberCdr);
        model.addInformation("type", "CDR's");
        model.addInformation("redirect", "upload");
		return model;
	}
}

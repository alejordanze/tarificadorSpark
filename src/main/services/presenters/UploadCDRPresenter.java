package main.services.presenters;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.interactors.UploadCDR.UploadCDRBoundaryOutputPort;
import main.application.interactors.UploadConfirm.UploadConfirmBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class UploadCDRPresenter extends Presenter implements UploadConfirmBoundaryOutputPort{

	@Override
	public StringWriter present(int numberCdr) {
		ResponseModel model = new ResponseModel();
        model.addInformation("quantity", numberCdr);
        model.addInformation("type", "CDR's");
        model.addInformation("redirect", "upload");
		return getTemplate(model, "uploadConfirm.ftl");
	}
}

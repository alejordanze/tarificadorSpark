package main.services.presenters;

import java.io.StringWriter;

import main.application.interactors.UploadConfirm.UploadConfirmBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class UploadConfirmCDRPresenter extends Presenter implements UploadConfirmBoundaryOutputPort{

	@Override
	public StringWriter present(int numberCdr) {
		ResponseModel model = new ResponseModel();
        model.addInformation("quantity", numberCdr);
        model.addInformation("type", "CDR's");
        model.addInformation("redirect", "upload");
		return getTemplate(model, "uploadConfirm.ftl");
	}
}

package main.services.presenters;

import java.io.StringWriter;
import java.util.List;

import main.application.interactors.UploadCDR.UploadBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;
import main.domain.CDR;

public class UploadCDRPresenter extends Presenter implements UploadBoundaryOutputPort {
	
	@Override
	public StringWriter present() {
		ResponseModel model = new ResponseModel();
		return getTemplate(model, "upload.ftl");
	}

}

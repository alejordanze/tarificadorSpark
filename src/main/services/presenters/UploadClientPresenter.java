package main.services.presenters;

import java.io.StringWriter;

import main.application.interactors.Upload.UploadBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class UploadClientPresenter extends Presenter implements UploadBoundaryOutputPort{

	@Override
	public StringWriter present() {
		ResponseModel model = new ResponseModel();
		return getTemplate(model, "uploadClient.ftl");
	}

}

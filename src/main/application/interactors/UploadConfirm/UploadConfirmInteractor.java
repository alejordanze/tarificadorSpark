package main.application.interactors.UploadConfirm;

import java.io.StringWriter;

import main.application.models.responseModel.ResponseModel;


public class UploadConfirmInteractor implements UploadConfirmBoundaryInputPort{

	UploadConfirmBoundaryOutputPort uploadClientBoundaryOutputPort;
	
	public UploadConfirmInteractor(UploadConfirmBoundaryOutputPort uploadClientBoundaryOutputPort) {
		this.uploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort;
	}
	
	@Override
	public StringWriter execute(int numberCdr) {
        return uploadClientBoundaryOutputPort.present(numberCdr);
	}
}

package main.application.interactors.UploadCDR;

import java.io.StringWriter;

import main.application.models.responseModel.ResponseModel;

public class UploadInteractor implements UploadBoundaryInputPort{
	
	UploadBoundaryOutputPort uploadCDRBoundaryOutputPort;
	
	public UploadInteractor(UploadBoundaryOutputPort uploadCDRBoundaryOutputPort) {
		this.uploadCDRBoundaryOutputPort = uploadCDRBoundaryOutputPort;
	}
	@Override
	public StringWriter execute() {
        return uploadCDRBoundaryOutputPort.present();
	}

}

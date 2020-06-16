package main.application.interactors.UploadCDR;

import main.application.models.responseModel.ResponseModel;

public class UploadCDRInteractor implements UploadCDRBoundaryInputPort{
	
	UploadCDRBoundaryOutputPort uploadCDRBoundaryOutputPort;
	
	public UploadCDRInteractor(UploadCDRBoundaryOutputPort uploadCDRBoundaryOutputPort) {
		this.uploadCDRBoundaryOutputPort = uploadCDRBoundaryOutputPort;
	}
	@Override
	public ResponseModel execute(int numberCdr) {
        return uploadCDRBoundaryOutputPort.present(numberCdr);
	}

}

package main.application.interactors.UploadClient;

import main.application.models.responseModel.ResponseModel;


public class UploadClientInteractor implements UploadClientBoundaryInputPort{

	UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort;
	
	public UploadClientInteractor(UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort) {
		this.uploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort;
	}
	
	@Override
	public ResponseModel execute(int numberCdr) {
        ResponseModel responseUploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort.present(numberCdr);
        return responseUploadClientBoundaryOutputPort;
	}
}

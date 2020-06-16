package main.application.interactors.UploadCDR;

import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface UploadCDRBoundaryOutputPort {
	public ResponseModel present(int numberCdr);
}

package main.application.interactors.UploadClient;

import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface UploadClientBoundaryOutputPort {
	public ResponseModel present(int numberCdr);
}

package main.application.interactors.UploadCDR;

import java.util.Map;

import javax.servlet.http.Part;

import main.application.models.responseModel.ResponseModel;

public interface UploadCDRBoundaryInputPort {
	public ResponseModel execute(int numberCdr);
}

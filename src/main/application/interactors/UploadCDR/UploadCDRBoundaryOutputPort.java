package main.application.interactors.UploadCDR;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface UploadCDRBoundaryOutputPort {
	public StringWriter present(int numberCdr);
}

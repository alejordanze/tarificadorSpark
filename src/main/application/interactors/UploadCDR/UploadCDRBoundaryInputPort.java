package main.application.interactors.UploadCDR;

import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.Part;

import main.application.models.responseModel.ResponseModel;

public interface UploadCDRBoundaryInputPort {
	public StringWriter execute(int numberCdr);
}

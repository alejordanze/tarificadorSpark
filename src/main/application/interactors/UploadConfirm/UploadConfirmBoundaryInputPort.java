package main.application.interactors.UploadConfirm;

import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.Part;

import main.application.models.responseModel.ResponseModel;

public interface UploadConfirmBoundaryInputPort {
	public StringWriter execute(int numberCdr);
}

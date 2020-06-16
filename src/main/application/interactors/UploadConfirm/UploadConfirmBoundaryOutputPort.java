package main.application.interactors.UploadConfirm;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface UploadConfirmBoundaryOutputPort {
	public StringWriter present(int numberCdr);
}

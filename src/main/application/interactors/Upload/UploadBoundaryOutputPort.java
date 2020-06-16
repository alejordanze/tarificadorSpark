package main.application.interactors.Upload;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface UploadBoundaryOutputPort {
	public StringWriter present();
}

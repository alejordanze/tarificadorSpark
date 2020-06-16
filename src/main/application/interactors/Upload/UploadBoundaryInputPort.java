package main.application.interactors.Upload;

import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.Part;

import main.application.models.responseModel.ResponseModel;

public interface UploadBoundaryInputPort {
	public StringWriter execute();
}

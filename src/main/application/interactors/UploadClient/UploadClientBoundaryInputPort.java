package main.application.interactors.UploadClient;

import java.util.Map;

import javax.servlet.http.Part;

import main.application.models.responseModel.ResponseModel;

public interface UploadClientBoundaryInputPort {
	public ResponseModel execute(Part filePart);
}

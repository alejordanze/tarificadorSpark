package main.interactor.UploadCDR;

import java.util.Map;

import javax.servlet.http.Part;

public interface UploadCDRBoundaryInputPort {
	public Map<String, Object> execute(Part filePart);
}

package main.interactor.UploadClient;

import java.util.Map;

import javax.servlet.http.Part;

public interface UploadClientBoundaryInputPort {
	public Map<String, Object> execute(Part filePart);
}

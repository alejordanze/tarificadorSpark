package main.interactor.UploadClient;

import java.util.Map;

public interface UploadClientBoundaryOutputPort {
	public Map<String, Object> present(Map<String, Object> model);
}

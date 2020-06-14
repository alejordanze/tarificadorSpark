package main.application.interactors.UploadClient;

import java.util.Map;

public interface UploadClientBoundaryOutputPort {
	public Map<String, Object> present(int numberCdr);
}

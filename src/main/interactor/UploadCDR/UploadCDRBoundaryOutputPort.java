package main.interactor.UploadCDR;

import java.util.Map;

public interface UploadCDRBoundaryOutputPort {
	public Map<String, Object> present(int numberCdr);
}

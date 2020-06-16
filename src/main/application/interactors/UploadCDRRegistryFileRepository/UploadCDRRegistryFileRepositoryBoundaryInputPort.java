package main.application.interactors.UploadCDRRegistryFileRepository;

import spark.Request;

public interface UploadCDRRegistryFileRepositoryBoundaryInputPort {
	public int execute(Request request);
}

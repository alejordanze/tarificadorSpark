package main.application.interactors.UploadClientFileRepository;

import java.util.Map;

import spark.Request;

public interface UploadClientFileRepositoryBoundaryInputPort {
	public int execute(Request request);
}

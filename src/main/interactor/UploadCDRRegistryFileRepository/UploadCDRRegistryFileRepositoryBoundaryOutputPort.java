package main.interactor.UploadCDRRegistryFileRepository;

import java.util.List;

import main.entities.CDR;

public interface UploadCDRRegistryFileRepositoryBoundaryOutputPort {
	public int present(List<CDR> registry);
}

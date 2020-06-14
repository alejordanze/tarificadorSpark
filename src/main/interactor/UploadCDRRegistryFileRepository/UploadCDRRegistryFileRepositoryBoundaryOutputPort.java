package main.interactor.UploadCDRRegistryFileRepository;

import java.util.List;

import domain.CDR;

public interface UploadCDRRegistryFileRepositoryBoundaryOutputPort {
	public int present(List<CDR> registry);
}

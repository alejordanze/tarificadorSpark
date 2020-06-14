package main.application.interactors.UploadCDRRegistryFileRepository;

import java.util.List;

import main.domain.CDR;

public interface UploadCDRRegistryFileRepositoryBoundaryOutputPort {
	public int present(List<CDR> registry);
}

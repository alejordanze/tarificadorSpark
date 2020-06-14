package main.services;

import java.util.List;

import main.entities.CDR;
import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;

public class UploadCDRRegistryFileRepositoryPresenter implements UploadCDRRegistryFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<CDR> registry) {
		return registry.size();
	}

}

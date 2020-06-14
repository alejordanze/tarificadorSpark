package main.services.presenters;

import java.util.List;

import main.application.interactors.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;
import main.domain.CDR;

public class UploadCDRRegistryFileRepositoryPresenter implements UploadCDRRegistryFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<CDR> registry) {
		return registry.size();
	}

}

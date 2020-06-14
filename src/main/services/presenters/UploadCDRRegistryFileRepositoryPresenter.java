package main.services.presenters;

import java.util.List;

import domain.CDR;
import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;

public class UploadCDRRegistryFileRepositoryPresenter implements UploadCDRRegistryFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<CDR> registry) {
		return registry.size();
	}

}

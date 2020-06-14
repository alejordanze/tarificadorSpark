package main.services;

import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;

public class UploadCDRRegistryFileRepositoryPresenter implements UploadCDRRegistryFileRepositoryBoundaryOutputPort{

	@Override
	public int present(int size) {
		return size;
	}

}

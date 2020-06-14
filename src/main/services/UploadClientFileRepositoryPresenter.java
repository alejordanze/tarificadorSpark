package main.services;

import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;

public class UploadClientFileRepositoryPresenter implements UploadClientFileRepositoryBoundaryOutputPort{

	@Override
	public int present(int size) {
		return size;
	}

}

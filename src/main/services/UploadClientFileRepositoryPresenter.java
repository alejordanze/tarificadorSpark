package main.services;

import java.util.List;

import domain.Client;
import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;

public class UploadClientFileRepositoryPresenter implements UploadClientFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<Client> clients) {
		return clients.size();
	}

}

package main.services.presenters;

import java.util.List;

import main.domain.Client;
import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;

public class UploadClientFileRepositoryPresenter implements UploadClientFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<Client> clients) {
		return clients.size();
	}

}

package main.services.presenters;

import java.util.List;

import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;
import main.domain.Client;

public class UploadClientFileRepositoryPresenter implements UploadClientFileRepositoryBoundaryOutputPort{

	@Override
	public int present(List<Client> clients) {
		return clients.size();
	}

}

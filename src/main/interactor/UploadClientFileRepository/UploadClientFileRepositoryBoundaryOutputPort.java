package main.interactor.UploadClientFileRepository;

import java.util.List;

import main.entities.Client;

public interface UploadClientFileRepositoryBoundaryOutputPort {
	public int present(List<Client> clients);
}

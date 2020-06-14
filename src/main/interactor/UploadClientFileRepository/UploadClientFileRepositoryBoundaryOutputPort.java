package main.interactor.UploadClientFileRepository;

import java.util.List;

import domain.Client;

public interface UploadClientFileRepositoryBoundaryOutputPort {
	public int present(List<Client> clients);
}

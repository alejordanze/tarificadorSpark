package main.application.interactors.UploadClientFileRepository;

import java.util.List;

import main.domain.Client;

public interface UploadClientFileRepositoryBoundaryOutputPort {
	public int present(List<Client> clients);
}

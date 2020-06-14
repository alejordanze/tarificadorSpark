package main.interactor.UploadClientFileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import main.dataAccess.ClientFileRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.entities.Client;
import main.entities.ClientRegistry;

public class UploadClientFileRepositoryInteractor implements UploadClientFileRepositoryBoundaryInputPort{

	static Repository<Client> clientRepository = new ClientFileRepository();
	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);

	UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort;
	
	public UploadClientFileRepositoryInteractor(UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort) {
		this.uploadClientFileRepositoryBoundaryOutputPort = uploadClientFileRepositoryBoundaryOutputPort;
	}
	
	@Override
	public int execute(String file) {
		FileRepository<Client> fileRepo = new ClientFileRepository(file);
		List<Client> clients = new ArrayList<>();
		for(Client client: fileRepo.getRegistry()) {
//			if(verifyNumber(client.getPhoneNumber())) {
				clients.add(client);
//			}
		}
		uploadclientRegister.setClientes(clients);
		uploadclientRegister.saveRegistry();
		return uploadClientFileRepositoryBoundaryOutputPort.present(uploadclientRegister.getClients().size());
	}

}

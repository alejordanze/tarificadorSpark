package main.application.interactors.UploadClientFileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import main.application.gateway.Repository;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryInputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.FileRepository.FileRepository;
import main.domain.Client;
import main.domain.ClientRegistry;

public class UploadClientFileRepositoryInteractor implements UploadClientFileRepositoryBoundaryInputPort{

	ClientRegistry uploadclientRegister;
	
	UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort;
	
	VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort;
	
	public UploadClientFileRepositoryInteractor(UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort, 	VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort, ClientRegistry uploadclientRegister) {
		this.uploadClientFileRepositoryBoundaryOutputPort = uploadClientFileRepositoryBoundaryOutputPort;
		this.verifyNumberClientBoundaryInputPort = verifyNumberClientBoundaryInputPort;
		this.uploadclientRegister = uploadclientRegister;
	}
	
	@Override
	public int execute(String file) {
		FileRepository<Client> fileRepo = new ClientFileRepository(file);
		List<Client> clients = new ArrayList<>();
		for(Client client: fileRepo.getRegistry()) {
//			if(verifyNumberClientBoundaryInputPort.execute(client.getPhoneNumber())) {
				clients.add(client);
//			}
		}
		uploadclientRegister.setClientes(clients);
		uploadclientRegister.saveRegistry();
		return uploadClientFileRepositoryBoundaryOutputPort.present(uploadclientRegister.getClients());
	}

}

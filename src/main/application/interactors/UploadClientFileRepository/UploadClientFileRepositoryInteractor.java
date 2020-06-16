package main.application.interactors.UploadClientFileRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import main.application.gateways.Repository;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryInputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;
import main.application.utils.FileUpload;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.ClientFileRepository;
import main.dataAccess.FileRepository.FileRepository;
import main.domain.CDR;
import main.domain.Client;
import main.domain.ClientRegistry;
import spark.Request;
import spark.utils.IOUtils;

public class UploadClientFileRepositoryInteractor implements UploadClientFileRepositoryBoundaryInputPort{

	ClientRegistry uploadclientRegister;
	
	UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort;
	
	VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort;
	
	public UploadClientFileRepositoryInteractor(UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort, 	VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort, ClientRegistry uploadclientRegister) {
		this.uploadClientFileRepositoryBoundaryOutputPort = uploadClientFileRepositoryBoundaryOutputPort;
		this.verifyNumberClientBoundaryInputPort = verifyNumberClientBoundaryInputPort;
		this.uploadclientRegister = uploadclientRegister;
	}
	
	public void upload(Request req) {
		FileUpload uploadFile = new FileUpload();
    	FileRepository<Client> fileRepo = new ClientFileRepository(uploadFile.upload(req));
		List<Client> clients = new ArrayList<>();
		for(Client client: fileRepo.getRegistry()) {
//    			if(verifyNumberClientBoundaryInputPort.execute(client.getPhoneNumber())) {
				clients.add(client);
//    			}
		}
		uploadclientRegister.setClientes(clients);
		uploadclientRegister.saveRegistry();
	}
	
	@Override
	public int execute(Request req) {
		upload(req);
		return uploadClientFileRepositoryBoundaryOutputPort.present(uploadclientRegister.getClients());
	}

}

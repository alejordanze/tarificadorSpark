package main.interactor.UploadCDRRegistryFileRepository;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.entities.Client;
import main.entities.ClientRegistry;
import main.interactor.CDRRegistry;

public class UploadCDRRegistryFileRepositoryInteractor implements UploadCDRRegistryFileRepositoryBoundaryInputPort{

	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);
	static Repository<Client> clientRepository = new ClientFileRepository();
	static ClientRegistry clientRegister = new ClientRegistry(clientRepository);

	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort;
	public UploadCDRRegistryFileRepositoryInteractor(	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort) {
		this.uploadCDRRegistryFileRepositoryBoundaryOutputPort = uploadCDRRegistryFileRepositoryBoundaryOutputPort;
	}
	
	@Override
	public int execute(String file) {
		FileRepository<CDR> fileRepo = new CDRFileRepository(file);
		uploadCDRregister.setRegistry(fileRepo.getRegistry(), clientRegister);
		return uploadCDRRegistryFileRepositoryBoundaryOutputPort.present(uploadCDRregister.getRegistry().size());
	}

}

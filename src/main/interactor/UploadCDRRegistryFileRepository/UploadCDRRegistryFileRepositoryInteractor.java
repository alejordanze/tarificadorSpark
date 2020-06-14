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

	CDRRegistry uploadCDRregister;
	ClientRegistry clientRegister;
	
	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort;
	public UploadCDRRegistryFileRepositoryInteractor(UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort, CDRRegistry uploadCDRregister,ClientRegistry clientRegister) {
		this.uploadCDRRegistryFileRepositoryBoundaryOutputPort = uploadCDRRegistryFileRepositoryBoundaryOutputPort;
		this.uploadCDRregister = uploadCDRregister;
		this.clientRegister = clientRegister;
	}
	
	@Override
	public int execute(String file) {
		FileRepository<CDR> fileRepo = new CDRFileRepository(file);
		uploadCDRregister.setRegistry(fileRepo.getRegistry(), clientRegister);
		return uploadCDRRegistryFileRepositoryBoundaryOutputPort.present(uploadCDRregister.getRegistry());
	}

}

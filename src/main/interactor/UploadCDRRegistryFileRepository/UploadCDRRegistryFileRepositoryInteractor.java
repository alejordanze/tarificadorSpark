package main.interactor.UploadCDRRegistryFileRepository;

import domain.CDR;
import domain.CDRRegistry;
import domain.Client;
import domain.ClientRegistry;
import main.dataAccess.CDRFileRepository;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;

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

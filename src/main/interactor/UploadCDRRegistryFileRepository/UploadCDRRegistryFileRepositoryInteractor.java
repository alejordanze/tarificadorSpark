package main.interactor.UploadCDRRegistryFileRepository;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.Client;
import main.domain.ClientRegistry;

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

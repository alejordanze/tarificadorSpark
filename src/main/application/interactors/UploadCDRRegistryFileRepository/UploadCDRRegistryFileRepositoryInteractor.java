package main.application.interactors.UploadCDRRegistryFileRepository;

import main.application.utils.FileUpload;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.dataAccess.FileRepository.FileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;
import main.domain.ClientRegistry;
import spark.Request;

public class UploadCDRRegistryFileRepositoryInteractor implements UploadCDRRegistryFileRepositoryBoundaryInputPort{

	CDRRegistry uploadCDRregister;
	ClientRegistry clientRegister;
	
	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort;
	public UploadCDRRegistryFileRepositoryInteractor(UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort, CDRRegistry uploadCDRregister,ClientRegistry clientRegister) {
		this.uploadCDRRegistryFileRepositoryBoundaryOutputPort = uploadCDRRegistryFileRepositoryBoundaryOutputPort;
		this.uploadCDRregister = uploadCDRregister;
		this.clientRegister = clientRegister;
	}
	
	public void upload(Request req) {
		FileUpload uploadFile = new FileUpload();
    	FileRepository<CDR> fileRepo = new CDRFileRepository(uploadFile.upload(req));
		uploadCDRregister.setRegistry(fileRepo.getRegistry(), clientRegister);
	}
	
	@Override
	public int execute(Request req) {
		upload(req);
		return uploadCDRRegistryFileRepositoryBoundaryOutputPort.present(uploadCDRregister.getRegistry());
	}

}

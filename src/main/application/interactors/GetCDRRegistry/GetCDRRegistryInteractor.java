package main.application.interactors.GetCDRRegistry;

import java.util.Map;

import main.application.external.Repository;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;

public class GetCDRRegistryInteractor implements GetCDRRegistryBoundaryInputPort{

	GetCDRFromRepositoryBoundaryInputPort getCDRFromRepositoryBoundaryInputPort;
	GetCDRRegistryBoundaryOutputPort getCDRRegistryBoundaryOutputPort;
	CDRRegistry CDRregister;
	
	public GetCDRRegistryInteractor(GetCDRRegistryBoundaryOutputPort getCDRRegistryBoundaryOutputPort, CDRRegistry CDRregister) {
		this.getCDRRegistryBoundaryOutputPort=getCDRRegistryBoundaryOutputPort;
		this.CDRregister = CDRregister;
		this.getCDRFromRepositoryBoundaryInputPort = new GetCDRFromRepositoryInteractor(CDRregister);
	}
	
	@Override
	public Map<String, Object> execute() {
		getCDRFromRepositoryBoundaryInputPort.execute();
		return getCDRRegistryBoundaryOutputPort.present(CDRregister.getRegistry());
	}

}

package main.interactor.GetCDRRegistry;

import java.util.Map;

import domain.CDR;
import domain.CDRRegistry;
import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryInteractor;

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

package main.application.interactors.GetCDRRegistry;

import java.util.Map;

import main.application.gateways.Repository;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.application.models.responseModel.ResponseModel;
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
	public ResponseModel execute() {
		getCDRFromRepositoryBoundaryInputPort.execute();
		return getCDRRegistryBoundaryOutputPort.present(CDRregister.getRegistry());
	}

}

package main.interactor.GetCDRRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryInteractor;

public class GetCDRRegistryInteractor implements GetCDRRegistryBoundaryInputPort{

	static GetCDRFromRepositoryBoundaryInputPort getCDRFromRepositoryBoundaryInputPort = new GetCDRFromRepositoryInteractor();

	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);

	GetCDRRegistryBoundaryOutputPort getCDRRegistryBoundaryOutputPort;
	
	public GetCDRRegistryInteractor(GetCDRRegistryBoundaryOutputPort getCDRRegistryBoundaryOutputPort) {
		this.getCDRRegistryBoundaryOutputPort=getCDRRegistryBoundaryOutputPort;
	}
	
	@Override
	public Map<String, Object> execute() {
				
		Map<String, Object> model = new HashMap<>();
		getCDRFromRepositoryBoundaryInputPort.execute();
		model.put("cdrs", getCDRRegistryBoundaryOutputPort.present(CDRregister.getRegistry()));
		return model;
	}

}

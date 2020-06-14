package main.application.interactors.GetCDRFromRepository;

import main.application.gateway.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;

public class GetCDRFromRepositoryInteractor implements GetCDRFromRepositoryBoundaryInputPort{
		
	CDRRegistry CDRregister;

	public GetCDRFromRepositoryInteractor(CDRRegistry CDRregister) {
		this.CDRregister = CDRregister;
	}
	@Override
	public void execute() {
		CDRregister.getCDRFromRepository();		
	}

}

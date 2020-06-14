package main.application.interactors.GetCDRFromRepository;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
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

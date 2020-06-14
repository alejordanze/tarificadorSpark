package main.interactor.GetCDRFromRepository;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

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

package main.interactor.GetCDRFromRepository;

import domain.CDR;
import domain.CDRRegistry;
import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;

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

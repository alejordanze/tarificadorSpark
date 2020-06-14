package main.interactor.GetCDRFromRepository;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

public class GetCDRFromRepositoryInteractor implements GetCDRFromRepositoryBoundaryInputPort{
	
	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);

	@Override
	public void execute() {
		CDRregister.getCDRFromRepository();		
	}

}

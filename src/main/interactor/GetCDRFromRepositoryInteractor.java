package main.interactor;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;

public class GetCDRFromRepositoryInteractor implements GetCDRFromRepositoryBoundaryInputPort{
	
	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry CDRregister = new CDRRegistry(repository);

	@Override
	public void execute() {
		CDRregister.getCDRFromRepository();		
	}

}

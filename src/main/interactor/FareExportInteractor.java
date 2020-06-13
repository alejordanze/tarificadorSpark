package main.interactor;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;

public class FareExportInteractor implements FareExportBoundaryInputPort{

	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);

	public FareExportInteractor() {
	}
	
	@Override
	public void execute() {
		uploadCDRregister.saveRegistry();
	}

}

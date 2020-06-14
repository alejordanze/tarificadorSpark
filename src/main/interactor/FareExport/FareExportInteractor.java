package main.interactor.FareExport;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

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

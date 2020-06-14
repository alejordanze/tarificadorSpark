package main.interactor.FareExport;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;
import main.interactor.CDRRegistry;

public class FareExportInteractor implements FareExportBoundaryInputPort{

	CDRRegistry uploadCDRregister;
	
	public FareExportInteractor(CDRRegistry uploadCDRregister) {
		this.uploadCDRregister = uploadCDRregister;
	}
	
	@Override
	public void execute() {
		uploadCDRregister.saveRegistry();
	}

}

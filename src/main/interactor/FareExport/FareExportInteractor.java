package main.interactor.FareExport;

import domain.CDR;
import domain.CDRRegistry;
import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;

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

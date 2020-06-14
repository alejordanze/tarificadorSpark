package main.application.interactors.FareExport;

import main.application.gateway.Repository;
import main.dataAccess.FileRepository.CDRFileRepository;
import main.domain.CDR;
import main.domain.CDRRegistry;

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

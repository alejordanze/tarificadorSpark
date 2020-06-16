package main.application.interactors.FareExport;

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

package main.interactor;

import java.util.Map;

import main.dataAccess.CDRFileRepository;
import main.dataAccess.Repository;
import main.entities.CDR;

public class FareExportInteractor implements FareExportBoundaryInputPort{

	static Repository<CDR> repository = new CDRFileRepository();
	static CDRRegistry uploadCDRregister = new CDRRegistry(repository);

	FareExportBoundaryOutputPort fareExportBoundaryOutputPort;

	public FareExportInteractor(FareExportBoundaryOutputPort fareExportBoundaryOutputPort) {
		this.fareExportBoundaryOutputPort = fareExportBoundaryOutputPort;
	}
	
	@Override
	public Map<String, Object> execute() {
		uploadCDRregister.saveRegistry();
		return null;
	}

}

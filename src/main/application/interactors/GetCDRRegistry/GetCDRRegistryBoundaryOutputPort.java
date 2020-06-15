package main.application.interactors.GetCDRRegistry;

import java.util.List;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDR;

public interface GetCDRRegistryBoundaryOutputPort {
	public ResponseModel present(List<CDR> list);


}

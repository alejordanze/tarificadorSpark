package main.application.interactors.GetCDRRegistry;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDR;

public interface GetCDRRegistryBoundaryOutputPort {
	public StringWriter present(List<CDR> list);


}

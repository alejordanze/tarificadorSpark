package main.interactor.GetCDRRegistry;

import java.util.List;
import java.util.Map;

import main.entities.CDR;

public interface GetCDRRegistryBoundaryOutputPort {
	public Map<String, Object> present(List<CDR> list);


}

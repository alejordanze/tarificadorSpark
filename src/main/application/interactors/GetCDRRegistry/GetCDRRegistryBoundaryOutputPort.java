package main.application.interactors.GetCDRRegistry;

import java.util.List;
import java.util.Map;

import main.domain.CDR;

public interface GetCDRRegistryBoundaryOutputPort {
	public Map<String, Object> present(List<CDR> list);


}

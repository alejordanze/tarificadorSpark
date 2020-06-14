package main.interactor.GetCDRRegistry;

import java.util.List;
import java.util.Map;

import main.entities.CDR;

public interface GetCDRRegistryBoundaryOutputPort {
	public Map<Long, List<CDR>> present(List<CDR> list);


}

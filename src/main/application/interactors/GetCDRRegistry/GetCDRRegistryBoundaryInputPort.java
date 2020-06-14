package main.application.interactors.GetCDRRegistry;

import java.util.List;
import java.util.Map;

import main.domain.CDR;

public interface GetCDRRegistryBoundaryInputPort {
	public Map<String, Object> execute();
}

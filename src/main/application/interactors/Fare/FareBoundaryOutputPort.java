package main.application.interactors.Fare;

import java.util.Map;

import main.domain.CDRRegistry;

public interface FareBoundaryOutputPort {
	public Map<String, Object> present(CDRRegistry cdrRegistry,String option,boolean saved);
}

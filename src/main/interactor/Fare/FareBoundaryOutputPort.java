package main.interactor.Fare;

import java.util.Map;

import main.interactor.CDRRegistry;

public interface FareBoundaryOutputPort {
	public Map<String, Object> present(CDRRegistry cdrRegistry,String option,boolean saved);
}

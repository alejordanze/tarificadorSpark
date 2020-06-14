package main.application.interactors.Fare;

import java.util.Map;

public interface FareBoundaryInputPort {
	public Map<String, Object> execute(boolean saved);
}

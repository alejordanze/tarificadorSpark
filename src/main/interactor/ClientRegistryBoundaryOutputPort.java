package main.interactor;

import java.util.Map;

public interface ClientRegistryBoundaryOutputPort {
	public Map<String, Object> present(Map<String, Object> model);
}

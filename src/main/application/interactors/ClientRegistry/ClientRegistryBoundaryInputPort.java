package main.application.interactors.ClientRegistry;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface ClientRegistryBoundaryInputPort {
	public StringWriter execute();

}

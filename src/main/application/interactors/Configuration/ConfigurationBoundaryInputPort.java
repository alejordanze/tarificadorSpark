package main.application.interactors.Configuration;

import java.io.StringWriter;

public interface ConfigurationBoundaryInputPort {

	public StringWriter execute(String option);
}

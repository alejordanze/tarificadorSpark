package main.application.interactors.Configuration;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


public interface ConfigurationBoundaryOutputPort {
	public StringWriter present(String option);
}

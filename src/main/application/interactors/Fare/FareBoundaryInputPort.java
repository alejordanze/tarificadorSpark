package main.application.interactors.Fare;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface FareBoundaryInputPort {
	public StringWriter execute(boolean saved);
}

package main.application.interactors.Fare;

import java.io.StringWriter;
import java.util.Map;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDRRegistry;

public interface FareBoundaryOutputPort {
	public StringWriter present(CDRRegistry cdrRegistry,String option,boolean saved);
}

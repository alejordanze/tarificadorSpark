package main.application.interactors.Fare;

import java.util.Map;

import main.application.models.responseModel.ResponseModel;

public interface FareBoundaryInputPort {
	public ResponseModel execute(boolean saved);
}

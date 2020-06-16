package main.application.interactors.Billing;

import org.json.JSONObject;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDRRegistry;

public interface BillingBoundaryInputPort {
	public JSONObject execute(CDRRegistry cdrRegister, String phone);
}

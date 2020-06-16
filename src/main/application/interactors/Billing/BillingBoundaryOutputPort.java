package main.application.interactors.Billing;

import org.json.JSONObject;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDRRegistry;

public interface BillingBoundaryOutputPort {
	public JSONObject present(CDRRegistry cdrRegister, String phone);

}

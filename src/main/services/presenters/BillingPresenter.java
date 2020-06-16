package main.services.presenters;

import org.json.JSONObject;

import main.application.interactors.Billing.BillingBoundaryOutputPort;
import main.domain.CDRRegistry;
import main.application.models.responseModel.ResponseModel;

public class BillingPresenter implements BillingBoundaryOutputPort{

	@Override
	public JSONObject present(CDRRegistry cdrRegister, String phone) {
		JSONObject json = new JSONObject();
		json.put("consumption", cdrRegister.getClientConsumption(Long.valueOf(phone)));
		return json;
	}

}

package main.application.interactors.Billing;

import org.json.JSONObject;

import main.application.models.responseModel.ResponseModel;
import main.domain.CDRRegistry;

public class BillingInteractor implements BillingBoundaryInputPort{

	BillingBoundaryOutputPort billingBoundaryOutputPort;
	public BillingInteractor(BillingBoundaryOutputPort billingBoundaryOutputPort) {
		this.billingBoundaryOutputPort = billingBoundaryOutputPort;
	}
	
	@Override
	public JSONObject execute(CDRRegistry cdrRegister, String phone) {
		return this.billingBoundaryOutputPort.present(cdrRegister, phone);		
	}

}

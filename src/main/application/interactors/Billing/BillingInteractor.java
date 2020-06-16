package main.application.interactors.Billing;

import main.application.models.responseModel.ResponseModel;

public class BillingInteractor implements BillingBoundaryInputPort{

	BillingBoundaryOutputPort billingBoundaryOutputPort;
	public BillingInteractor(BillingBoundaryOutputPort billingBoundaryOutputPort) {
		this.billingBoundaryOutputPort = billingBoundaryOutputPort;
	}
	
	@Override
	public ResponseModel execute() {
		return null;		
	}

}

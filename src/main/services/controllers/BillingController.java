package main.services.controllers;

import static spark.Spark.get;

import java.io.StringWriter;

import main.application.interactors.Billing.BillingBoundaryInputPort;
import main.application.interactors.Billing.BillingBoundaryOutputPort;
import main.application.interactors.Billing.BillingInteractor;
import main.services.presenters.BillingPresenter;
import spark.Route;

public class BillingController extends Controller{

	static BillingBoundaryOutputPort billingBoundaryOutputPort = new BillingPresenter();
	static BillingBoundaryInputPort billingBoundaryInputPort = new BillingInteractor(billingBoundaryOutputPort);	
	
	public static void getMethod() {
		get("/facturar", (request, response) -> {
			return billingBoundaryInputPort.execute();
		});
		
	}
	
	public static void init() {
		getMethod();
	}
}

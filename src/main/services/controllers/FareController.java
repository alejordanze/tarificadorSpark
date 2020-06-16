package main.services.controllers;

import static spark.Spark.get;
import static spark.Spark.post;
import main.application.interactors.Fare.FareBoundaryInputPort;
import main.application.interactors.Fare.FareBoundaryOutputPort;
import main.application.interactors.Fare.FareInteractor;
import main.application.interactors.FareExport.FareExportBoundaryInputPort;
import main.application.interactors.FareExport.FareExportInteractor;
import main.services.presenters.FarePresenter;

public class FareController extends Controller {

	static FareBoundaryOutputPort fareBoundaryOutputPort = new FarePresenter();
	static FareBoundaryInputPort fareBoundaryInputPort = new FareInteractor(fareBoundaryOutputPort,uploadCDRregister,option);

	static FareExportBoundaryInputPort fareExportBoundaryInputPort = new FareExportInteractor(uploadCDRregister);

	private static void export() {
		fareExportBoundaryInputPort.execute();
	}
	
	public static void getMethod() {
		get("/fare", (request, response) -> {
			return fareBoundaryInputPort.execute(false);
		});
	}
	
	public static void postMethod() {
		post("/fare", (request, response) -> {
			export();
			return fareBoundaryInputPort.execute(true);
		});
	}
	
	public static void init() {
		getMethod();
		postMethod();
	}
}

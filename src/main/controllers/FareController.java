package main.controllers;

import static spark.Spark.get;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.interactor.FareBoundaryInputPort;
import main.interactor.FareBoundaryOutputPort;
import main.interactor.FareExportBoundaryInputPort;
import main.interactor.FareExportInteractor;
import main.interactor.FareInteractor;
import main.services.FarePresenter;

public class FareController extends Controller {

	static FareBoundaryOutputPort fareBoundaryOutputPort = new FarePresenter();
	static FareBoundaryInputPort fareBoundaryInputPort = new FareInteractor(fareBoundaryOutputPort);

	static FareExportBoundaryInputPort fareExportBoundaryInputPort = new FareExportInteractor();

	private static void export() {
		fareExportBoundaryInputPort.execute();
	}
	
	private static Map<String, Object> getModel(boolean saved){
		return fareBoundaryInputPort.execute(saved);
	}
	
	public static void getMethod() {
		get("/fare", (request, response) -> {
			return getTemplate(getModel(false), "export.ftl");
		});
	}
	
	public static void postMethod() {
		post("/fare", (request, response) -> {
			export();
			return getTemplate(getModel(true), "export.ftl");
		});
	}
	
	public static void init() {
		getMethod();
		postMethod();
	}
}

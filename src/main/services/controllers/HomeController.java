package main.services.controllers;

import static spark.Spark.get;

import main.application.interactors.Home.HomeBoundaryInputPort;
import main.application.interactors.Home.HomeBoundaryOutputPort;
import main.application.interactors.Home.HomeInteractor;
import main.services.presenters.HomePresenter;

public class HomeController extends Controller {

	static HomeBoundaryOutputPort homeBoundaryOutputPort = new HomePresenter();
	static HomeBoundaryInputPort homeBoundaryInputPort = new HomeInteractor(homeBoundaryOutputPort);

	public static void getMethod() {
		get("/", (req, res) -> {
			return getTemplate(homeBoundaryInputPort.execute(), "index.ftl");
		});
	}
	
	public static void init() {
		getMethod();
	}

}

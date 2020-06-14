package main.controllers;

import static spark.Spark.get;

import main.interactor.Home.HomeBoundaryInputPort;
import main.interactor.Home.HomeBoundaryOutputPort;
import main.interactor.Home.HomeInteractor;
import main.services.HomePresenter;

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

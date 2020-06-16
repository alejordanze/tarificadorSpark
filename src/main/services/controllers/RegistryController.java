package main.services.controllers;

import static spark.Spark.get;

import java.util.*;

import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.application.interactors.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.application.interactors.GetCDRRegistry.GetCDRRegistryBoundaryInputPort;
import main.application.interactors.GetCDRRegistry.GetCDRRegistryBoundaryOutputPort;
import main.application.interactors.GetCDRRegistry.GetCDRRegistryInteractor;
import main.application.interactors.Home.HomeBoundaryInputPort;
import main.application.interactors.Home.HomeBoundaryOutputPort;
import main.application.interactors.Home.HomeInteractor;
import main.dataAccess.*;
import main.domain.CDR;
import main.services.presenters.GetCDRRegistryPresenter;
import main.services.presenters.HomePresenter;

public class RegistryController extends Controller{
		
	static GetCDRRegistryBoundaryOutputPort getCDRRegistryBoundaryOutputPort = new GetCDRRegistryPresenter();
	static GetCDRRegistryBoundaryInputPort getCDRRegistryBoundaryInputPort = new GetCDRRegistryInteractor(getCDRRegistryBoundaryOutputPort,CDRregister);
	
	public static void getMethod() {
		get("/registry", (request, response) -> {
			return getCDRRegistryBoundaryInputPort.execute();
		});
	}
	
	public static void init() {
		getMethod();
	}
}

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

	public static Map<Long, List<CDR>> sortByDate(List<CDR> list){
		Map<Long, List<CDR>> map = new TreeMap<>(Collections.reverseOrder());
		for(CDR cdr: list) {
			List<CDR> auxList = new ArrayList<>();
			java.util.Date date = cdr.getDateAdded();
			
			for(CDR cdr2: list) {
				if(date.equals(cdr2.getDateAdded())) {
					auxList.add(cdr2);
				}
			}
			map.put(date.getTime(), auxList);
		}
		return map;
	}
	
	public static void getMethod() {
//		get("/registry", (request, response) -> {
//			Map<String, Object> model = new HashMap<>();
//			getCDRFromRepositoryBoundaryInputPort.execute();
//			model.put("cdrs", getCDRRegistryBoundaryInputPort.execute());
//			return getTemplate(model, "registry.ftl");
//		});
		
		
		get("/registry", (request, response) -> {
			return getTemplate(getCDRRegistryBoundaryInputPort.execute(), "registry.ftl");
		});
		
	}
	
	public static void init() {
		
		getMethod();
	}
}

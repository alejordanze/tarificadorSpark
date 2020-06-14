package main.controllers;

import static spark.Spark.get;

import java.util.*;

import domain.CDR;
import main.dataAccess.*;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryBoundaryInputPort;
import main.interactor.GetCDRFromRepository.GetCDRFromRepositoryInteractor;
import main.interactor.GetCDRRegistry.GetCDRRegistryBoundaryInputPort;
import main.interactor.GetCDRRegistry.GetCDRRegistryBoundaryOutputPort;
import main.interactor.GetCDRRegistry.GetCDRRegistryInteractor;
import main.interactor.Home.HomeBoundaryInputPort;
import main.interactor.Home.HomeBoundaryOutputPort;
import main.interactor.Home.HomeInteractor;
import main.services.GetCDRRegistryPresenter;
import main.services.HomePresenter;

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

package main.controllers;

import static spark.Spark.get;

import java.util.*;

import main.dataAccess.*;
import main.entities.CDR;

public class RegistryController extends Controller{
	
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
		get("/registry", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			CDRregister.getCDRFromRepository();	
			model.put("cdrs", sortByDate(CDRregister.getRegistry()));
			return getTemplate(model, "registry.ftl");
		});
		
	}
	
	public static void init() {
		
		getMethod();
	}
}

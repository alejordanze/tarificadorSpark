package main.domain;

import static java.util.Arrays.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.application.gateways.Repository;

public class CDRRegistry {

	List<CDR> registry = new ArrayList<>();
	Repository<CDR> repository;
	
	public CDRRegistry(Repository<CDR> repository) {
		this.repository = repository;
	}
	
	public CDRRegistry() {
	}
	
	public void addCDR(CDR cdr, ClientRegistry clientsList) {
		cdr.calculateCostCall(clientsList);
		this.registry.add(cdr);
	}
	
	public List<CDR> getRegistry() {
		return registry;
	}
	
	public Repository<CDR> getRepository() {
		return repository;
	}

	public void setRepository(Repository<CDR> repository) {
		this.repository = repository;
	}

	
	private List<CDR> calculateCDRListCost(List<CDR> CDRList, ClientRegistry clientsList) {
		for( CDR cdr : CDRList) {
			cdr.calculateCostCall(clientsList);
		}
		return CDRList;
	}

	public void setRegistry(List<CDR> registry,  ClientRegistry clientsList) {
		this.registry = this.calculateCDRListCost(registry, clientsList);
	}
	
	public void saveRegistry(){
		this.repository.exportRegistry(registry);  
	}
	
	public void getCDRFromRepository()
	{
		this.registry = this.repository.getRegistry();
	}
	
	@SuppressWarnings("deprecation")
	public List<Map<String, String>> getClientConsumption(long number) {
		List<Map<String,String>> listOfMap = new ArrayList<>();
		List<String> months = asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
		months.forEach((String month) -> {
			Map<String, String> map = new HashMap<>();
			double consumption = 0;
			for(CDR cdr: this.registry){
				if(cdr.getOriginPhoneNumber() == number && cdr.getDate().getMonth() == Integer.parseInt(month)) {
					consumption += cdr.getCost();
				}
			}
			if(consumption > 0) {
				map.put("month", month);
				map.put("amount", Double.toString(this.round(consumption, 2)));
				listOfMap.add(map);
			}
		});
		return listOfMap;
	}
	
	private double round(double number, int places) {
		 BigDecimal bd = new BigDecimal(Double.toString(number));
		 bd = bd.setScale(places, RoundingMode.HALF_UP);
		 return bd.doubleValue();
	 }
	
}

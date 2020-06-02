package main.interactor;


import java.util.ArrayList;
import java.util.List;

import main.dataAccess.Repository;
import main.entities.CDR;
import main.entities.ClientRegistry;

public class CDRRegistry {

	List<CDR> registry = new ArrayList<>();
	Repository repository;
	
	public CDRRegistry(Repository repository) {
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
	
	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
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
}
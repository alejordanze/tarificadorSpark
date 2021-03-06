package main.application.gateways;


import java.util.*;

import main.domain.CDR;

public interface Repository<T> {

	public void exportRegistry(List<T> registry);
	public List<T> getRegistry();

}

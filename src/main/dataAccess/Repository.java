package main.dataAccess;


import java.util.*;

import main.entities.CDR;

public interface Repository {

	public void exportRegistry(List<CDR> registry);
	public List<CDR> getRegistry();
}

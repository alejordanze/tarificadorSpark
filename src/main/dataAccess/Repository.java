package main.dataAccess;


import java.util.*;

import main.entities.CDR;

public interface Repository<T> {

	public void exportRegistry(List<T> registry);
	public List<T> getRegistry();

}

package main.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.entities.CDR;
import main.interactor.GetCDRRegistry.GetCDRRegistryBoundaryOutputPort;

public class GetCDRRegistryPresenter implements GetCDRRegistryBoundaryOutputPort{

	@Override
	public Map<Long, List<CDR>> present(List<CDR> list) {
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

}

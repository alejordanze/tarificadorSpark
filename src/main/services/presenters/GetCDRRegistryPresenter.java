package main.services.presenters;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.application.interactors.GetCDRRegistry.GetCDRRegistryBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;
import main.domain.CDR;

public class GetCDRRegistryPresenter extends Presenter implements GetCDRRegistryBoundaryOutputPort{

	@Override
	public StringWriter present(List<CDR> list) {
		ResponseModel model = new ResponseModel();
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
		model.addInformation("cdrs", map);
		
		return getTemplate(model, "registry.ftl");
	}

}

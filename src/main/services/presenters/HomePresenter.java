package main.services.presenters;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import main.application.interactors.Home.HomeBoundaryOutputPort;
import main.application.models.responseModel.ResponseModel;

public class HomePresenter extends Presenter implements HomeBoundaryOutputPort{

	@Override
	public StringWriter present() {
		ResponseModel model = new ResponseModel();
		return getTemplate(model, "index.ftl");
	}

}

package main.services.controllers;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import domain.*;
import main.dataAccess.*;
import main.interactor.UploadClient.UploadClientBoundaryInputPort;
import main.interactor.UploadClient.UploadClientBoundaryOutputPort;
import main.interactor.UploadClient.UploadClientInteractor;
import main.services.presenters.UploadClientPresenter;
import spark.utils.IOUtils;

public class UploadClientController extends Controller {
	
	static UploadClientBoundaryOutputPort uploadClientBoundaryOuputPort = new UploadClientPresenter();
	static UploadClientBoundaryInputPort uploadClientBoundaryInputPort = new UploadClientInteractor(uploadClientBoundaryOuputPort,numberCdr,clientRepository,uploadclientRegister);
		
	public static void getMethod() {
		get("/uploadClient", (req,res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "uploadClient.ftl");
		});
	}
	
	public static void postMethod() {
		post("/uploadClient", (req, response) -> {
			String path = "/Users/miguelalejandrojordan/";
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
            Part filePart = req.raw().getPart("myfile");
            return getTemplate(uploadClientBoundaryInputPort.execute(filePart), "uploadConfirm.ftl");
        });
	}
	
	
	public static void init() {
		getMethod();
		postMethod();
	}

}

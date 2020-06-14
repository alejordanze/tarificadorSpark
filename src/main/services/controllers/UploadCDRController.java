package main.services.controllers;

import static java.util.Arrays.asList;
import static spark.Spark.get;
import static spark.Spark.post;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.application.interactors.UploadCDR.UploadCDRBoundaryInputPort;
import main.application.interactors.UploadCDR.UploadCDRBoundaryOutputPort;
import main.application.interactors.UploadCDR.UploadCDRInteractor;
import main.dataAccess.*;
import main.domain.CDR;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.FareByHour;
import main.domain.NormalFare;
import main.domain.Plan;
import main.domain.Postpaid;
import main.domain.Prepaid;
import main.domain.Wow;
import main.services.presenters.UploadCDRPresenter;
import spark.utils.IOUtils;

public class UploadCDRController extends Controller {

	static UploadCDRBoundaryOutputPort uploadCDRBoundaryOutputPort = new UploadCDRPresenter();
	static UploadCDRBoundaryInputPort uploadCDRBoundaryInputPort = new UploadCDRInteractor(uploadCDRBoundaryOutputPort,numberCdr,uploadCDRregister,clientRegister);
		
	public static List<Client> getSampleClients(){
		Plan prepago = new Prepaid(new NormalFare(1.45), asList(new FareByHour(0.85, 2130, 2359)));
		Plan postpago = new Postpaid(1);
		Wow wow = new Wow(0.99);
		
		return asList(
				new Client(prepago, 7777777, "Ivy Rocabado"),
				new Client(postpago, 6666666, "Saskia Sejas"),
				new Client(wow, 8888888, "Naida Rocabado")
				);
	}
	
	public static void getMethod() {
		get("/upload", (req,res) -> {
			Map<String, Object> model = new HashMap<>();
			return getTemplate(model, "upload.ftl");
		});
	}

	public static void postMethod() {
		post("/upload", (req, response) -> {
			String path = "/Users/miguelalejandrojordan/";
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
	        Part filePart = req.raw().getPart("myfile");
            return getTemplate(uploadCDRBoundaryInputPort.execute(filePart), "uploadConfirm.ftl");
        });
	}

	public static void init() {
		getMethod();
		postMethod();
	}
	

}

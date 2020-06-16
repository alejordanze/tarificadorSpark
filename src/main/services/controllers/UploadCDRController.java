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
import main.application.interactors.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryInputPort;
import main.application.interactors.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;
import main.application.interactors.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryInteractor;
import main.application.interactors.UploadConfirm.UploadConfirmBoundaryInputPort;
import main.application.interactors.UploadConfirm.UploadConfirmBoundaryOutputPort;
import main.application.interactors.UploadConfirm.UploadConfirmInteractor;
import main.application.models.responseModel.ResponseModel;
import main.dataAccess.*;
import main.domain.CDR;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.domain.Fare.FareByHour;
import main.domain.Fare.NormalFare;
import main.domain.Plan.Plan;
import main.domain.Plan.Postpaid;
import main.domain.Plan.Prepaid;
import main.domain.Plan.Wow;
import main.services.presenters.UploadCDRPresenter;
import main.services.presenters.UploadCDRRegistryFileRepositoryPresenter;
import spark.utils.IOUtils;

public class UploadCDRController extends Controller {

	static UploadConfirmBoundaryOutputPort uploadConfirmBoundaryOutputPort = new UploadCDRPresenter();
	static UploadConfirmBoundaryInputPort uploadConfirmBoundaryInputPort = new UploadConfirmInteractor(uploadConfirmBoundaryOutputPort);
	
	static 	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort = new UploadCDRRegistryFileRepositoryPresenter();
	static UploadCDRRegistryFileRepositoryBoundaryInputPort uploadCDRRegistryFileRepositoryBoundaryInputPort  = new UploadCDRRegistryFileRepositoryInteractor(uploadCDRRegistryFileRepositoryBoundaryOutputPort,uploadCDRregister,clientRegister);

	public static void getMethod() {
		get("/upload", (req,res) -> {
			ResponseModel model = new ResponseModel();
			return getTemplate(model, "upload.ftl");
		});
	}

	public static void postMethod() {
		post("/upload", (req, response) -> {
            numberCdr = uploadCDRRegistryFileRepositoryBoundaryInputPort.execute(req);
            return uploadConfirmBoundaryInputPort.execute(numberCdr);
        });
	}

	public static void init() {
		getMethod();
		postMethod();
	}
	

}

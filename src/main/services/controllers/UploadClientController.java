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

import main.domain.*;
import main.application.interactors.UploadClient.UploadClientBoundaryInputPort;
import main.application.interactors.UploadClient.UploadClientBoundaryOutputPort;
import main.application.interactors.UploadClient.UploadClientInteractor;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryInputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryInteractor;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryInputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientInteractor;
import main.application.models.responseModel.ResponseModel;
import main.dataAccess.*;
import main.services.presenters.UploadClientFileRepositoryPresenter;
import main.services.presenters.UploadClientPresenter;
import main.services.presenters.VerifyNumberClientPresenter;
import spark.utils.IOUtils;

public class UploadClientController extends Controller {
	
	static UploadClientBoundaryOutputPort uploadClientBoundaryOuputPort = new UploadClientPresenter();
	static UploadClientBoundaryInputPort uploadClientBoundaryInputPort = new UploadClientInteractor(uploadClientBoundaryOuputPort);

	static VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort = new VerifyNumberClientPresenter();
	static VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort= new VerifyNumberClientInteractor(verifyNumberClientBoundaryOutputPort,clientRepository);

	static UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort = new UploadClientFileRepositoryPresenter();
	static UploadClientFileRepositoryBoundaryInputPort uploadClientFileRepositoryBoundaryInputPort = new UploadClientFileRepositoryInteractor(uploadClientFileRepositoryBoundaryOutputPort,verifyNumberClientBoundaryInputPort,uploadclientRegister);

	
	public static void getMethod() {
		get("/uploadClient", (req,res) -> {
			ResponseModel model = new ResponseModel();
			return getTemplate(model, "uploadClient.ftl");
		});
	}
	
	public static void postMethod() {
		post("/uploadClient", (req, response) -> {
			String path = "/Users/miguelalejandrojordan/";
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
            Part filePart = req.raw().getPart("myfile");
            try (InputStream inputStream = filePart.getInputStream()) {
            	String fileName = path + filePart.getSubmittedFileName();
                OutputStream outputStream = new FileOutputStream(fileName);
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
                numberCdr = uploadClientFileRepositoryBoundaryInputPort.execute(fileName);
            }
            return getTemplate(uploadClientBoundaryInputPort.execute(numberCdr), "uploadConfirm.ftl");
        });
	}
	
	
	public static void init() {
		getMethod();
		postMethod();
	}

}

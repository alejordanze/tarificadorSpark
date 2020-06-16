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
import main.application.interactors.Upload.UploadBoundaryInputPort;
import main.application.interactors.Upload.UploadBoundaryOutputPort;
import main.application.interactors.Upload.UploadInteractor;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryInputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryInteractor;
import main.application.interactors.UploadConfirm.UploadConfirmBoundaryInputPort;
import main.application.interactors.UploadConfirm.UploadConfirmBoundaryOutputPort;
import main.application.interactors.UploadConfirm.UploadConfirmInteractor;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryInputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientInteractor;
import main.application.models.responseModel.ResponseModel;
import main.dataAccess.*;
import main.services.presenters.UploadCDRPresenter;
import main.services.presenters.UploadClientFileRepositoryPresenter;
import main.services.presenters.UploadClientPresenter;
import main.services.presenters.UploadConfirmClientPresenter;
import main.services.presenters.VerifyNumberClientPresenter;
import spark.utils.IOUtils;

public class UploadClientController extends Controller {
	
	static UploadConfirmBoundaryOutputPort uploadConfirmBoundaryOuputPort = new UploadConfirmClientPresenter();
	static UploadConfirmBoundaryInputPort uploadConfirmBoundaryInputPort = new UploadConfirmInteractor(uploadConfirmBoundaryOuputPort);

	static VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort = new VerifyNumberClientPresenter();
	static VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort= new VerifyNumberClientInteractor(verifyNumberClientBoundaryOutputPort,clientRepository);

	static UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort = new UploadClientFileRepositoryPresenter();
	static UploadClientFileRepositoryBoundaryInputPort uploadClientFileRepositoryBoundaryInputPort = new UploadClientFileRepositoryInteractor(uploadClientFileRepositoryBoundaryOutputPort,verifyNumberClientBoundaryInputPort,uploadclientRegister);

	static UploadBoundaryOutputPort uploadClientOutputPort = new UploadClientPresenter();
	static UploadBoundaryInputPort uploadClientInputPort = new UploadInteractor(uploadClientOutputPort);
	
	public static void getMethod() {
		get("/uploadClient", (req,res) -> {
			return uploadClientInputPort.execute();
		});
	}
	
	public static void postMethod() {
		post("/uploadClient", (req, response) -> {
            numberCdr = uploadClientFileRepositoryBoundaryInputPort.execute(req);
            return uploadConfirmBoundaryInputPort.execute(numberCdr);
        });
	}
	
	
	public static void init() {
		getMethod();
		postMethod();
	}

}

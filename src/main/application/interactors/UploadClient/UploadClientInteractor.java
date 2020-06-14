package main.application.interactors.UploadClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryInputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;
import main.application.interactors.UploadClientFileRepository.UploadClientFileRepositoryInteractor;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryInputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientBoundaryOutputPort;
import main.application.interactors.VerifyNumberClient.VerifyNumberClientInteractor;
import main.dataAccess.ClientFileRepository;
import main.dataAccess.ClientSqlRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.domain.Client;
import main.domain.ClientRegistry;
import main.services.presenters.UploadClientFileRepositoryPresenter;
import main.services.presenters.VerifyNumberClientPresenter;
import spark.utils.IOUtils;

import javax.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadClientInteractor implements UploadClientBoundaryInputPort{

	UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort;
	
	UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort = new UploadClientFileRepositoryPresenter();
	
	VerifyNumberClientBoundaryOutputPort verifyNumberClientBoundaryOutputPort = new VerifyNumberClientPresenter();
	VerifyNumberClientBoundaryInputPort verifyNumberClientBoundaryInputPort;
	UploadClientFileRepositoryBoundaryInputPort uploadClientFileRepositoryBoundaryInputPort;
	
	int numberCdr;
	Repository<Client> clientRepository;

	public UploadClientInteractor(UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort, int numberCdr, Repository<Client> clientRepository, ClientRegistry uploadclientRegister) {
		this.uploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort;
		this.numberCdr= numberCdr;
		this.clientRepository = clientRepository;
		this.verifyNumberClientBoundaryInputPort = new VerifyNumberClientInteractor(verifyNumberClientBoundaryOutputPort,clientRepository);
		this.uploadClientFileRepositoryBoundaryInputPort   = new UploadClientFileRepositoryInteractor(uploadClientFileRepositoryBoundaryOutputPort,verifyNumberClientBoundaryInputPort,uploadclientRegister);
	}
	
	@Override
	public Map<String, Object> execute(Part filePart) {
		String path = "/Users/miguelalejandrojordan/";
        try (InputStream inputStream = filePart.getInputStream()) {
        	String fileName = path + filePart.getSubmittedFileName();
            OutputStream outputStream = new FileOutputStream(fileName);
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();
            numberCdr = uploadClientFileRepositoryBoundaryInputPort.execute(fileName);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map<String, Object> responseUploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort.present(numberCdr);
        return responseUploadClientBoundaryOutputPort;
	}
}

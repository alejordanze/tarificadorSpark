package main.interactor.UploadClient;

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

import main.dataAccess.ClientFileRepository;
import main.dataAccess.ClientSqlRepository;
import main.dataAccess.FileRepository;
import main.dataAccess.Repository;
import main.entities.Client;
import main.entities.ClientRegistry;
import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryBoundaryInputPort;
import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryBoundaryOutputPort;
import main.interactor.UploadClientFileRepository.UploadClientFileRepositoryInteractor;
import main.services.UploadClientFileRepositoryPresenter;
import spark.utils.IOUtils;

import javax.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadClientInteractor implements UploadClientBoundaryInputPort{

	UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort;
	
	UploadClientFileRepositoryBoundaryOutputPort uploadClientFileRepositoryBoundaryOutputPort = new UploadClientFileRepositoryPresenter();
	UploadClientFileRepositoryBoundaryInputPort uploadClientFileRepositoryBoundaryInputPort  = new UploadClientFileRepositoryInteractor(uploadClientFileRepositoryBoundaryOutputPort);
	
	static int numberCdr;
	static Repository<Client> clientRepository = new ClientFileRepository();
	static ClientRegistry uploadclientRegister = new ClientRegistry(clientRepository);

	public UploadClientInteractor(UploadClientBoundaryOutputPort uploadClientBoundaryOutputPort) {
		this.uploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort;
	}

	
	public static boolean verifyNumber(long number) {
		return ((ClientSqlRepository) clientRepository).isPhoneAvailable(number);
	}
	
	@Override
	public Map<String, Object> execute(Part filePart) {
		String path = "/Users/miguelalejandrojordan/";
		Map<String, Object> model = new HashMap<>();
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
        model.put("quantity", numberCdr);
        model.put("type", "Clientes");
        model.put("redirect", "uploadClient");
        Map<String, Object> responseUploadClientBoundaryOutputPort = uploadClientBoundaryOutputPort.present(model);
        return responseUploadClientBoundaryOutputPort;
	}
}

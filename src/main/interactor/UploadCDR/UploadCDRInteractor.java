package main.interactor.UploadCDR;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryInputPort;
import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryBoundaryOutputPort;
import main.interactor.UploadCDRRegistryFileRepository.UploadCDRRegistryFileRepositoryInteractor;
import main.services.UploadCDRRegistryFileRepositoryPresenter;
import spark.utils.IOUtils;

public class UploadCDRInteractor implements UploadCDRBoundaryInputPort{

	UploadCDRRegistryFileRepositoryBoundaryOutputPort uploadCDRRegistryFileRepositoryBoundaryOutputPort = new UploadCDRRegistryFileRepositoryPresenter();
	UploadCDRRegistryFileRepositoryBoundaryInputPort uploadCDRRegistryFileRepositoryBoundaryInputPort = new UploadCDRRegistryFileRepositoryInteractor(uploadCDRRegistryFileRepositoryBoundaryOutputPort);
	
	UploadCDRBoundaryOutputPort uploadCDRBoundaryOutputPort;
	static int numberCdr;
	
	public UploadCDRInteractor(UploadCDRBoundaryOutputPort uploadCDRBoundaryOutputPort) {
		this.uploadCDRBoundaryOutputPort = uploadCDRBoundaryOutputPort;
	}
	@Override
	public Map<String, Object> execute(Part filePart) {
		String path = "/Users/miguelalejandrojordan/";
        try (InputStream inputStream = filePart.getInputStream()) {
        	String fileName = path + filePart.getSubmittedFileName();
            OutputStream outputStream = new FileOutputStream(fileName);
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();
            numberCdr = uploadCDRRegistryFileRepositoryBoundaryInputPort.execute(fileName);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return uploadCDRBoundaryOutputPort.present(numberCdr);
	}

}

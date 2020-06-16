package main.application.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import spark.Request;
import spark.utils.IOUtils;

public class FileUpload {
	
	String path;
	InputStream inputStream;
	OutputStream outputStream;
	Part filePart;
	String fileName;
	
	public String upload(Request req) {
		this.path = "/Users/miguelalejandrojordan/";
		req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(path));
        try { 
        	this.filePart = req.raw().getPart("myfile");
        	this.inputStream = filePart.getInputStream();
        	this.fileName = path + filePart.getSubmittedFileName();
            this.outputStream = new FileOutputStream(fileName);
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();
        } catch (IOException | ServletException e) {
			e.printStackTrace();
		}
        return this.fileName;
	}
	
}

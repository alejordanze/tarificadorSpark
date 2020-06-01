package main.dataAccess;


import java.util.*;

import main.entities.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public interface FileRepository<T> extends Repository<T> {

	default public String getTodayDate() {
		String today = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(today); 
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	public String headboardFile();
	
	public String nameFile();
	
	public String messageWrite(T t);

	
	public default void exportRegistry(List<T> registry) {
		File file = new File(nameFile() + getTodayDate() + ".csv");
        FileWriter fw;
		try {
			fw = new FileWriter(file);
		   BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(headboardFile());
	        bw.newLine();
	        
	        for(T t: registry) {
	        	bw.write(messageWrite(t));
	        	bw.newLine();
	        }
	        bw.close();
	        fw.close();
		} catch (IOException e) {
			System.out.println("Error: The file doesn't exist or is corrupted");
			e.printStackTrace();
		}
	}
}

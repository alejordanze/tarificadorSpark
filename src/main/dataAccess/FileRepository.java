package main.dataAccess;


import java.util.*;

import main.entities.*;
import main.interactor.CDRRegistry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public abstract class FileRepository<T> implements Repository<T> {

	String fileName;
	Timestamp dateAdded;
	
	 public String getTodayDate() {
		String today = "MM-dd-yyyy HH.mm.ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(today); 
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	public abstract String headboardFile();
	
	public abstract String nameFile();
	
	public abstract String messageWrite(T t);

	
	public void exportRegistry(List<T> registry) {
		this.dateAdded = new Timestamp(new Date().getTime());
		Writer fw;
		File file = new File(nameFile() + getTodayDate() + ".csv");
//        FileWriter fw; 
		try {
			fw = new FileWriter(this.fileName, true);
//			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
//	        bw.write(headboardFile());
	        for(T t: registry) {
	        	bw.append(messageWrite(t));
	        	bw.newLine();
	        }
	        bw.close();
	        fw.close();
		} catch (IOException e) {
			System.out.println("Error: The file doesn't exist or is corrupted");
			e.printStackTrace();
		}
	}
	
	public List<T> getRegistry(){
		List<T> list = new ArrayList<T>();
		String line = "";
        String cvsSplitBy = ", ";
        try{
        	BufferedReader br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while((line = br.readLine()) != null) {
	            String[] string = line.split(cvsSplitBy);
	            T t = getItem(string);
				list.add(t);
			}
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public abstract T getItem(String[] string);
}

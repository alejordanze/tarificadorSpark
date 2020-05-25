package main;


import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileRepository implements Repository {

	public String getTodayDate() {
		String today = "MM-dd-yyyy"; 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(today); 
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	@Override
	public void exportRegistry(List<CDR> registry) {
		File file = new File("CDRregister " + getTodayDate() + ".csv");
        FileWriter fw;
		try {
			fw = new FileWriter(file);
		   BufferedWriter bw = new BufferedWriter(fw);
	        bw.write("Origen, Destino, Duracion, Hora, Fecha, Costo");
	        bw.newLine();
	        
	        for(CDR cdr: registry) {
	        	bw.write(cdr.join());
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

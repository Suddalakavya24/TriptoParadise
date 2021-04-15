package ATripToParadise;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.*;
import java.util.Map.Entry;

public class CountTravTripwise implements Serializable{
	private static CountTravTripwise ref=null;
	static CountTravTripwise getInstance() throws FileNotFoundException {
		if(ref==null) {
		ref=new CountTravTripwise();	
		}
		return ref;
	}
	static Properties pr=new Properties();
	static FileOutputStream fis=null;
	static FileInputStream fin=null;
	 private CountTravTripwise() throws FileNotFoundException {
		 fis=new FileOutputStream("E://CountTravTripwise.txt");
		 fin=new FileInputStream("E://CountTravTripwise.txt");
	    pr.put("FamilyTour3N4D", 0);
		pr.put("GoaWithBeachvacation4D3N", 0);
		pr.put("GoaLeisureVacation4D3N", 0);
		pr.put("Amarnathyatra2N3D", 0);
		pr.put("Vaishnodevi2N3D", 0);
		
	}
	void count(String tripchosen) {
		int c=(int) pr.get(tripchosen);
		if(c==0)
		pr.put(tripchosen, 1);
		else pr.put(tripchosen, c+1);
	}
	void displayReport() {
		System.out.println("------Report on Bookings--------\n");
		Set<Entry<Object,Object>> entries=pr.entrySet();
		for(Entry<Object,Object> entry:entries) {
			System.out.println("Trip: "+entry.getKey()+", Number of bookings: "+entry.getValue()+"\n");
		}
	}
	void store() throws IOException {
		pr.store(fis, new Date().toString());
	}
	void load() throws IOException {
	   pr.load(fin);
	}
}

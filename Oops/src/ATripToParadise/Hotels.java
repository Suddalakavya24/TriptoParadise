package ATripToParadise;

import java.util.Observable;
import java.util.Observer;

public class Hotels implements Observer {
	String hotelname="";
    public Hotels(String hotelname) {
    	this.hotelname=hotelname;
    }
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		TravellerInfo info=(TravellerInfo)arg;
		System.out.println("Hotel Naaradha is alloted to "+info.name);
		
	}

}

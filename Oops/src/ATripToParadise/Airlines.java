package ATripToParadise;

import java.util.Observable;
import java.util.Observer;

public class Airlines implements Observer {
	String flightname="";
    Airlines(String flightname){
    	this.flightname=flightname;
    }
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
      TravellerInfo info=(TravellerInfo)arg;
      String name=info.name;
      System.out.println("Flight Indigo is the flight assigned to "+name);
		
	}

}

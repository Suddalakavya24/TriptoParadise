package ATripToParadise;
import ATripToParadise.ExceptionPackage.*;

import java.io.Serializable;
import java.util.Observable;
import java.util.Scanner;


public class JammuTour extends Observable implements Serializable {
	Scanner scan=new Scanner(System.in);
   short packageselected;
   StringBuffer bday1=null;
   StringBuffer bday2=null;
   public JammuTour() {
	   
   }
   public JammuTour(TravellerInfo obj) {
	   bday1=new StringBuffer("");
	   bday2=new StringBuffer("");
   }
   public StringBuffer day1() {
	   if(packageselected==4) {
		   bday1.append("Welcome to AmarnathYathra Tour\nScheduled arrive Srinagar Airport,meet our agent who will help you in reaching the Hotel\nEnjoy the amazing view of deep valleys and mountains\nDepart to Pahelgham\n");
		   }
	   else if(packageselected==5) {
		   bday1.append("Welcome to Vaishnodeviyathra! You will meet our representative outside Katra station\nOvernight stay in the hotel\n");
		
	   }
	   return bday1;
   }
   public StringBuffer day2() {
      if(packageselected==4) {
    	  bday2.append("Have breakfast and be ready to travel to Panchtarni and start trecking to reach the amarnath cave\nCome back to Pahelgam \n Leave for srinagar\nThankyou for opting this, we hope you had a great trip\n");
		      }
	   else if(packageselected==5) {
		   bday2.append("Have breakfast! leave for Vaishnavidevi temple \nCome back!Have dinner!Checkout from hotel and drop to station for your next journey.\n");
		    }
	  return bday2;
   }
   public void raisedException() {
	   System.out.println("No problem\n");
   }
}
class Amarnathyatra2N3D extends JammuTour{
	public Amarnathyatra2N3D(TravellerInfo obj) {
		packageselected=4;
		this.addObserver(new Hotels("Naradha"));
		setChanged();
		notifyObservers(obj);
	}
	public void raisedException() {
		try {
			throw new PoorService("Poor service!");
		}
		catch(PoorService e) {
			System.out.println(e);
			String r=e.toString();
			if(r.contentEquals("Poor service!")) {
				System.out.println("Select one of the options\n1.Poor Food\n2.Poor Accomodation\n3.Poor Transport\n");
				int response=scan.nextInt();
				if(response==1) {
					System.out.println("Sorry for the inconvinience! Food quality will be improved by Hotel management\n");
				}
				else if(response==2) {
					System.out.println("Sorry for the inconvinience! we will look into your problem\n");
				}
				else {
					System.out.println("Sorry for the inconvinience! our representative looks after the quality of transport\n");
				}
			}
			else {
				System.out.println("We will look into the problem\n");
			}
		}
	}
	
}
 class Vaishnodevi2N3D extends JammuTour{
	public Vaishnodevi2N3D (TravellerInfo obj) {
		packageselected=5;
		this.addObserver(new Hotels("Naradha"));
		setChanged();
		notifyObservers(obj);
	}
	static void Addon() {
		System.out.println("We are providing free hotel service\n");
	}
	public void raisedException() {
		try {
			throw new choosetripException("Package change");
			
		}
		catch(choosetripException e) {
			System.out.println(e);
			String response=e.toString();
			if(response.contentEquals("Package change")) {
				System.out.println("We are providing additional offers!\n");
				Addon();
			}
			else {
				System.out.println("Thankyou!\n");
			}
		}
	}
	
}
class Holidaypackagewithponyride extends GoaTrip{//singleton class
	public static class PonyRide
	{
		private final short horses=8;
		private static PonyRide ref = null;
		public PonyRide()
		{
		 	
		}
		 
		public static PonyRide getInstance()
		{  	
			if(ref==null)
			{
				ref = new PonyRide();
				return ref;
			}
			else
				return ref;
		}
		public void goUp()
		{   System.out.println("Available horses are only "+horses);
			System.out.println("Get ready to climb up to the temple\n");
		}
		public void comeDown()
		{
			System.out.println("Get ready to go back to the hotel");
		}
	}
	public void anyException()
	{
		System.out.println("Iam not feeling well I will go back.\n");
	}
}




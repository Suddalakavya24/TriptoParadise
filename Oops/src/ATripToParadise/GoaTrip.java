package ATripToParadise;
import java.io.Serializable;
import java.util.Observable;

import ATripToParadise.ExceptionPackage.*;
public class GoaTrip extends Observable implements Serializable {
	short packageselected;
	StringBuffer bday1=null;
	StringBuffer bday2=null;
	StringBuffer bday3=null;
	StringBuffer bday4=null;
	public GoaTrip(){
		bday1=new StringBuffer("");
		bday2=new StringBuffer("");
		bday3=new StringBuffer("");
		bday4=new StringBuffer("");}
	public StringBuffer day1() {
		if(packageselected==1) {
			this.bday1.append("Welcome to GOA! Scheduled arrive Goa airport.\nMeet our agent who will assist you to transfer to hotel\nBreakfast lunch and dinner are provided to the entire family.\nRest of the time you can take rest-No place is scheduled today.\n");
		}
		else if(packageselected==2) {
			this.bday1.append("Welcome to GOA! Scheduled arrive Goa airport.\nMeet our agent who will assist you to transfer to hotel\nBreakfast lunch and dinner are provided to the entire family.\nRest of the time you can take rest-No place is scheduled today.\n");
		}
		else if(packageselected==3) {
			this.bday1.append("Welcome to GOA! Scheduled arrive Goa airport.\nMeet our agent who will assist you to transfer to hotel\nBreakfast lunch and dinner are provided to the entire family.\nRest of the time you can take rest-No place is scheduled today.\n");

		}
		return bday1;
	}
	public StringBuffer day2() {
		if(packageselected==1) {
			this.bday2.append("Have breakfast in the hotel\nOur representative arranges your preferred vehicle.\nYou can go for sightseeing of Goa to the nearby beach.\nCome back ..have lunch in the hotel.\nOvernight stay in the hotel\n" );
		}
		else if(packageselected==2) {
			this.bday2.append("Have breakfast in the hotel\nYou are now going to visit famous\nSafa Masjid\nMapusa Town\nFriday bazaar\nLunch provision is optional\nEvening back to hotel .Overnight stay in the hotel\n");
		}
		else if(packageselected==3) {
			this.bday2.append("Take breakfast! Rest of the dayfree for your own activities\nLeisure visit to Colva beach\n");

		}
		return bday2;
	}
	public StringBuffer day3() {

		if(packageselected==1) {
			this.bday3.append("Have breakfast in the hotel.\nPalolem beach\nGoa Velha\nCalangutte are the scheduled places\nLunch will not be provided today\nHave dinner in the hotel\nAttend the grand party organized in the hotel\n");
		}
		else if(packageselected==2) {
			this.bday3.append("Have dinner in the hotel\nAttend the grand party organized in the hotel\nVisit Salimali bird sanctuary\nDudh sagar waterfalls\nPopular beach named Colva\nOvernight stay in the Hotel\n");

		}
		else if(packageselected==3) {
			this.bday3.append("Take breakfast!Full day sightseeing of north and south Goa\n");

		}
		return bday3;
	}
	public StringBuffer day4() {

		if(packageselected==1) {
			this.bday4.append("Have breakfast\nCan go for shopping!\nCome back ,have lunch spend wholeday at leisure until scheduled transfer to Goa airport/Railway station /bus station to board flight/bus/train\nThankyou for opting this package and the tour ends with full of happy memories\n" );
		}
		else if(packageselected==2) {
			this.bday4.append("Have breakfast\nCan go for shopping!\nCome back ,have lunch spend wholeday at leisure until scheduled transfer to Goa airport/Railway station /bus station to board flight/bus/train\nThankyou for opting this package and the tour ends with full of happy memories\n" );
		}
		else if(packageselected==3) {
			this.bday4.append("Have breakfast\nCan go for shopping!\nCome back ,have lunch spend wholeday at leisure until scheduled transfer to Goa airport/Railway station /bus station to board flight/bus/train\nThankyou for opting this package and the tour ends with full of happy memories\n" );

		}
		return bday4;
	}
	public void raisedException() {
		System.out.println("No problem\n");
	}

}
class FamilyTour3N4D extends GoaTrip{
	public FamilyTour3N4D (TravellerInfo obj) {
		packageselected=1;
		this.addObserver(new Airlines("Indigo"));
		setChanged();
		notifyObservers(obj);
	}
	public void raisedException() {
		try {
			throw new AirlineException("Flight got cancelled");
		}
		catch(AirlineException e){
			System.out.println(e);
			String ex=e.toString();
			if("Flight got cancelled".contentEquals(ex)) {
				System.out.println("Your flight got cancelled.Please wait for the furthur information\n");
			}
			else if("Flight got delayed".contentEquals(ex)) {
				System.out.println("Dont worry ! your flight just got delayed by an hour\n");
			}
		}
	}
	void Extra() {
		System.out.println("There are few special offers available:\n");
		System.out.println("1.Goa tour with qualifued guide.\n2. Medical services available with insurance\n");
	}
}
class GoaWithBeachvacation4D3N extends GoaTrip{
	public GoaWithBeachvacation4D3N(TravellerInfo obj) { packageselected=2;
	this.addObserver(new Airlines("Indigo"));
	setChanged();
	notifyObservers(obj);}
	public void raisedException() {
		try {
			throw new Badweather("Heavy rainfall");
		}
		catch(Badweather e) {
			System.out.println(e);
			String r=e.toString();
			if(r.contentEquals("Heavy rainfall")) {
				System.out.println("Daily schedule got cancelled due to heavy rain\nStay in the hotel\n");
			}
			else if(r.contentEquals("Stormy weather")) {
				System.out.println("Daily schedule got cancelled due to stormy weather\n");
			}
		}
	}

}
class GoaLeisureVacation4D3N extends GoaTrip{
	public GoaLeisureVacation4D3N(TravellerInfo obj) {
		packageselected=3;
		this.addObserver(new Airlines("Indigo"));
		setChanged();
		notifyObservers(obj);}
	public void raisedException() {
		try {
			throw new PoorAccomodation("Poor accomodation!");
		}
		catch(PoorAccomodation e) {
			System.out.println(e);
			String r=e.toString();
			if(r.contentEquals("Poor accomodation!"))
			{ if(Feedback()) {
				System.out.println("Problem resolved!We are sorry for the inconvinience! Please wait, we will provide you good accomodation\n");
			}
			else {
				System.out.println("Problem not resolved\n");
			}

			}
		}
	}
	public Boolean Feedback() {
		System.out.println("We will see to it\n");
		return true;
	}
}

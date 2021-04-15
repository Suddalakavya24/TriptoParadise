package ATripToParadise;

import java.io.Serializable;

public abstract class CustomPackageForGoaTrip{
	abstract public void day2();
	abstract public void day3();

}
 class GoaTripforwatersports extends CustomPackageForGoaTrip implements Serializable{
	public void day2() {
		System.out.println("Day2 schedule:\n");
		System.out.println("Have breakfast and go for adventurous water sports with dolphin spotting trip\n");
	    System.out.println("Overnight stay in the hotel\n");
	}
	public void day3() {
		System.out.println("Day3 schedule:\n");
		System.out.println("Have breakfast and go insearch of crocodiles with boat transfers\n");
		 System.out.println("Overnight stay in the hotel\n");
	}
}


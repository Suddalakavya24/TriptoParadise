package ATripToParadise;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import  ATripToParadise.allInterfaces.*;
public class TravellerInfo implements Serializable {
	String name,mail,address,DOB;
	long num;
	int age;
	String policychosen;
	GoaTrip ref1;
	JammuTour ref2;
	String TripChosen="";
	StringBuffer day1=null;
	StringBuffer day2=null;
	StringBuffer day3=null;
	StringBuffer day4=null;
	public int regnum;
	void setname(String name) {
		this.name=name;
	}
	String getname() {
		return name;
	}
	void setphn(long num) {
		this.num=num;
	}
	long getphn() {
		return num;	
	}
	void setmail(String mail) {
		this.mail=mail;
	}
	String getmail() {
		return mail;
	}
	void setaddress(String address) {
		this.address=address;
	}
	String getaddress() {
		return address;
	}

	void setage(int age) {
		this.age=age;
	}
	int getage() {
		return age;
	}
	public  String displaypolicies() {
		Scanner scan=new Scanner(System.in);
		System.out.println("The policies offered by us are:\n1.Primary health Insurance(Star health)\n2.Secondary health Insurance(ManipalCigna)\n");
		System.out.println("Choose one of the options\n");
		int choice=scan.nextInt();
		if(choice==1) {
			this.policychosen="Star health";
			MedicalInsurance policy1=new Starhealth();
			policy1.policyType();
			policy1.claimInsurance();
			policy1.Admissionprocess();
			policy1.reimbursement();
		}
		else if(choice==2) {
			this.policychosen="ManipalCigna";
			MedicalInsurance policy2=new ManipalCigna();
			policy2.policyType();
			policy2.claimInsurance();
			policy2.Admissionprocess();
			policy2.reimbursement();
		}return policychosen;
	}
	public  String chooseInsurance(String opt) {
		Scanner scan=new Scanner(System.in);
		if(opt.contentEquals("Y")) {
			System.out.println("Enter the name of policy\n");
			String policy=scan.next();
			this.policychosen=policy;
			return policychosen;
		}
		else if(opt.contentEquals("N")) {
			return this.displaypolicies();
		}
		return "";
	}


	void takeinfo() throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=scan.next();
		this.setname(name);
		System.out.println("Set up a password");
		String pwd=scan.next();

		System.out.println("Enter your phn num");
		long phn=scan.nextLong();
		this.setphn(phn);
		System.out.println("Enter your mail");
		String mail=scan.next();
		this.setmail(mail);
		System.out.println("Enter your address");
		String address=scan.next();
		this.setaddress(address);
		System.out.println("Enter your age");
		int age=scan.nextInt();
		this.setage(age);
		System.out.println("Do you have any health Insurance?(Y/N)");
		String opt=scan.next();
		String policy=this.chooseInsurance(opt);
		SaveInFile(name,pwd,phn,mail,address,age,policy);

	}
	public boolean SaveInFile(String name,String pwd,long phn,String mail,String Add,int age,String policy) throws IOException{
		File f=new File("E:\\file1.txt");
		FileWriter fo=new FileWriter(f,true);
		BufferedWriter bf=new BufferedWriter(fo);
		bf.write(name+","+pwd+","+phn+","+mail+","+Add+","+age+","+policy);
		bf.newLine();
		bf.close();
		return true;
	}
	void showuserinfo() {
		System.out.println("Name :"+this.getname());
		System.out.println("Phone number : "+this.getphn());
		System.out.println("Age :"+this.getage());
		System.out.println("Email :"+this.getmail());
		System.out.println("Address: "+this.getaddress());
		System.out.println("Policy chosen: \n"+policychosen);

	}
	void schedule1(GoaTrip ref1) {
		System.out.println("Day 1 schedule:\n");
		day1=ref1.day1();
		System.out.println("Day 2 schedule:\n");
		day2=(StringBuffer) ref1.day2();
		System.out.println("Day 3 schedule:\n");
		day3=(StringBuffer) ref1.day3();
		System.out.println("Day 4 schedule:\n");
		day4=(StringBuffer) ref1.day4();
	}
	void schedule2(JammuTour ref2) {
		System.out.println("Day 1 schedule:\n");
		day1=ref2.day1();
		System.out.println("Day 2 schedule:\n");
		day2=ref2.day2();

	}
	void generaterecipt() throws IOException {
		FileWriter fw=new FileWriter("E:/folder2/TravellerReceipts"+regnum+".txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("------------TRIP DETAILS---------------\n");
		bw.write("Booking Reference ID: "+this.regnum+"\n");
		bw.write("Name: "+this.name+"         Trip Chosen: "+this.TripChosen+"\n");
		bw.write("Email ID: "+this.mail+"\n");
		bw.write("DOB: "+this.DOB+"\n");
		bw.write("Age: "+this.age+"\n");
		bw.write("Address: "+this.address+"\n");
		bw.write("------------Iteniary------------------\n");
		bw.write("DAY 1:\n"+this.day1+"\n"+"DAY 2:\n"+this.day2+"\n"+"DAY 3:\n"+this.day3+"\n"+"DAY 4:\n"+this.day4+"\n");
		bw.write("-----------ENJOY--------------------\n");
		bw.flush();
		bw.close();

	}

	void selectpackage(int regnum) throws IOException {CountTravTripwise counttrav=CountTravTripwise.getInstance();
	this.regnum=regnum;
	Scanner scan=new Scanner(System.in);
	counttrav.displayReport();
	System.out.println("Select your preferred package\n");
	System.out.println("1.FamilyTour3N4D(Goa)\n2.GoaWithBeachvacation4D3N(Goa)\n3.GoaLeisureVacation4D3N(Goa)");
	System.out.println("4.Amarnathyatra2N3D(Jammu)\n5. Vaishnodevi2N3D(Jammu)");
	short choice=scan.nextShort();
	switch(choice) {
	case 1: ref1=new FamilyTour3N4D(this);
	TripChosen="FamilyTour3N4D";
	counttrav.count(TripChosen);
	System.out.println("Please look at the daily schedule\n");
	schedule1(ref1);
	System.out.println("Want to change your package to custom package-Goa trip for watersports?(Yes/No)\n");
	String Yes=scan.next();
	if(Yes.contentEquals("Yes")) {
		CustomPackageForGoaTrip reference=new GoaTripforwatersports();
		reference.day2();
		reference.day3();
	}
	else {
		System.out.println("You can go with the previous package\n");
	}
	System.out.println("Do you have any problem?Want to go back?(Y/N)\n");
	String c=scan.next();
	if(c.contentEquals("Y")) {
		ref1.raisedException();
	}
	else {
		System.out.println("Enjoy your trip\n");
	}
	break;
	case 2:ref1=new GoaWithBeachvacation4D3N(this);
	TripChosen="GoaWithBeachvacation4D3N";
	counttrav.count(TripChosen);
	System.out.println("Please look at the daily schedule\n");
	schedule1(ref1);
	System.out.println("Want to change your package to custom package-Goa trip for watersports?\n");
	String yes=scan.next();
	if(yes.contentEquals("Yes")) {
		CustomPackageForGoaTrip reference=new GoaTripforwatersports();
		reference.day2();
		reference.day3();
	}
	else {
		System.out.println("You can go with the previous package\n");
	}
	System.out.println("Do you have any problem?Want to go back?(Y/N)\n");
	String ch=scan.next();
	if(ch.contentEquals("Y")) {
		ref1.raisedException();
	}
	else {
		System.out.println("Enjoy your trip\n");
	}


	break;
	case 3: ref1=new GoaLeisureVacation4D3N(this);
	TripChosen="GoaLeisureVacation4D3N";
	counttrav.count(TripChosen);
	System.out.println("Please look at the daily schedule\n");
	schedule1(ref1);
	System.out.println("Do you have any problem?Want to go back?(Y/N)\n");
	String cho=scan.next();
	if(cho.contentEquals("Y")) {
		ref1.raisedException();
	}
	else {
		System.out.println("Enjoy your trip\n");
	}

	break;
	case 4: ref2=new Amarnathyatra2N3D(this);
	TripChosen="Amarnathyatra2N3D";
	counttrav.count(TripChosen);
	System.out.println("Please look at the daily schedule\n");
	schedule2(ref2);

	System.out.println("Want to have a ponyride to reach temple?(Y/N)\n");
	String C=scan.next();
	if(C.contentEquals("Y")) {
		Holidaypackagewithponyride ref1=new  Holidaypackagewithponyride();
		Holidaypackagewithponyride.PonyRide ref= new Holidaypackagewithponyride.PonyRide();
		ref.getInstance();
		ref.goUp();
		ref.comeDown();
		System.out.println("Do you have any problem?want to cancel the ride?(Y/N)\n");
		String Q=scan.next();
		if(Q.contentEquals("Y")) {
			ref1.anyException();}

	}
	else {
		System.out.println("Arrange your own transport and enjoy the ride\n");
	}
	System.out.println("Do you have any problem?Want to go back?(Y/N)\n");
	String choic=scan.next();
	if(choic.contentEquals("Y")) {
		ref2.raisedException();
	}
	else {
		System.out.println("Enjoy your trip\n");
	}

	break;
	case 5: ref2=new Vaishnodevi2N3D(this);
	TripChosen="Vaishnodevi2N3D";
	counttrav.count(TripChosen);
	System.out.println("Please look at the daily schedule\n");
	schedule2(ref2);
	System.out.println("Want to have a ponyride to reach temple?(Y/N)\n");
	String O=scan.next();
	if(O.contentEquals("Y")) {
		Holidaypackagewithponyride ref1=new  Holidaypackagewithponyride();
		Holidaypackagewithponyride.PonyRide ref= new Holidaypackagewithponyride.PonyRide();
		ref.getInstance();
		ref.goUp();
		ref.comeDown();
		System.out.println("Do you have any problem?want to cancel the ride ?(Y/N)\n");
		String P=scan.next();
		if(P.contentEquals("Y")) {
			ref1.anyException();}
	}
	else {
		System.out.println("Arrange your own transport and enjoy the ride\n");
	}
	System.out.println("Do you have any problem?Want to go back?(Y/N)\n");
	String option=scan.next();
	if(option.contentEquals("Y")) {
		ref2.raisedException();
	}
	else {
		System.out.println("Enjoy your trip\n");
	}



	break;

	}
	this.generaterecipt();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scan=new Scanner(System.in);
		int i;
		//  TravellerInfo person[]=new TravellerInfo[10];
		for( i=0;i<2;i++) {
			System.out.println("Welcome\nDo you want to login or Signup");
			String pref=scan.next();
			if(pref.contentEquals("login")) {
				File f=new File("E:/file1.txt");
				FileReader fr=new FileReader(f);
				BufferedReader bfr=new BufferedReader(fr);
				System.out.println("Welcome!\nEnter your registered name\n ");
				String nameofUser=scan.next();
				System.out.println("Enter your password\n ");
				String pwdofUser=scan.next();
				System.out.println("Enter your registeration id");
				int id=scan.nextInt();
				String line;

				while((line=bfr.readLine())!=null) {
					int counter=0;
					int ch=0;
					//  System.out.println(line);
					while(line.charAt(ch)!='\n') {
						if(line.charAt(ch)!=',') {
							counter++;
						}
						else break;
						ch++;
					}

					if(line.regionMatches( 0, nameofUser, 0, nameofUser.length())&&line.regionMatches(counter+1, pwdofUser, 0, pwdofUser.length())) {
						Thread t=new Thread(new Runnable(){public void run() {
							TravellerInfo  person=new TravellerInfo(); 
							System.out.println("Person - choose your package\n");
							try {
								person.selectpackage(id);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}}); 
						t.start();
						try {
							t.join();
							continue;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}


				}

				System.out.println("Invalid info\n");
			}
			else if(pref.contentEquals("Signup")) {

				Thread t=new Thread(new Createobj(new TravellerInfo()));

				t.start();
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		Deserialize d=new Deserialize();//deserialize all the traveller files at theend of the day to generate daily report
		d.deserializeObjects();
	}}
class Createobj implements Runnable{
	TravellerInfo person;
	public Createobj(TravellerInfo obj){
		this.person=obj;
	}
	public void run(){
		File f1=new File("E:\\folder1");
		int len=f1.list().length;
		int filename=len+1001;
		try {System.out.println("Your Registeratio ID: "+filename);
		person.takeinfo();
		System.out.println("Person - details:\n");
		FileOutputStream f=new FileOutputStream("E:\\folder1\\"+filename+"txt");
		ObjectOutputStream of=new ObjectOutputStream(f);
		person.showuserinfo();
		System.out.println("Person - choose your package\n");
		person.selectpackage(filename);
		of.writeObject(person);
		of.close();
		f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class Deserialize implements Serializable{
	Deserialize(){

	}
	void deserializeObjects() throws IOException, ClassNotFoundException {
		HashMap<String,TravellerInfo> hm=new HashMap<String,TravellerInfo>();
		TravellerInfo t=null;
		File f1=new File("E:\\folder1");
		File f[]=f1.listFiles();
		for(File i:f) {
			FileInputStream fi=new FileInputStream(i);
			ObjectInputStream of=new ObjectInputStream(fi);
			t=(TravellerInfo) of.readObject();
			hm.put(i.getName(),t);
			of.close();
			fi.close();
		}
		PrintSametripUsers(hm);
	}
	void PrintSametripUsers(HashMap<String,TravellerInfo> hm1) throws IOException{
		HashMap<String,ArrayList<String>> hm3=new HashMap<String,ArrayList<String>>();
		hm3.put("FamilyTour3N4D", new ArrayList<String>());
		hm3.put("GoaWithBeachvacation4D3N",new ArrayList<String>());
		hm3.put("GoaLeisureVacation4D3N", new ArrayList<String>());
		hm3.put("Amarnathyatra2N3D", new ArrayList<String>());
		hm3.put("Vaishnodevi2N3D",new ArrayList<String>());
		for(Entry<String, TravellerInfo> e: hm1.entrySet()) {
			hm3.get(e.getValue().TripChosen).add(e.getValue().name);
		}
		System.out.println("Trip wise traveller names:\n");
		for(Entry<String,ArrayList<String>> e:hm3.entrySet()) {
			System.out.println(e.getKey()+"-->"+e.getValue());
		}
		generateDailyReport(hm3);
	}
	void generateDailyReport(HashMap<String,ArrayList<String>> hm) throws IOException {
		FileWriter fis=new FileWriter("E:/ReportOnTrips.txt",true);
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
		BufferedWriter bf=new BufferedWriter(fis);
		bf.write("----------Daily Report On Trips Chosen------------\n");
		File f=new File("E:/folder1");
		int l=f.listFiles().length;
		bf.write("Total number of trips : "+l+"\n");
		for(Entry<String, ArrayList<String>> e: hm.entrySet()) {
			bf.write("Number of people who went for trip "+e.getKey()+" is "+e.getValue().size()+"\n");
			tm.put(e.getKey(), e.getValue().size());
		}
		Map.Entry<String,Integer> maxEntry=null;
		for(Map.Entry<String,Integer> entry:tm.entrySet()) {
			if(maxEntry==null||entry.getValue().compareTo(maxEntry.getValue())>0){
				maxEntry=entry;
			}
		}
		Map.Entry<String,Integer> minEntry=null;
		for(Map.Entry<String,Integer> entry:tm.entrySet()) {
			if(minEntry==null||entry.getValue().compareTo(minEntry.getValue())<0){
				minEntry=entry;
			}
		}

		bf.write("Trip with high demand is "+maxEntry.getKey()+" with "+maxEntry.getValue()+" bookings\n");
		bf.write("Trip with low demand is "+minEntry.getKey()+" with "+minEntry.getValue()+" bookings\n");
		bf.flush();
		bf.close();

	}
}

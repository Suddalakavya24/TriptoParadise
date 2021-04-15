package ATripToParadise.ExceptionPackage;

public class PoorAccomodation extends Exception{
	String exceptionname;
	   public PoorAccomodation(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }

}

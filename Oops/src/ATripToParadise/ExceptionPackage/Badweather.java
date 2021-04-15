package ATripToParadise.ExceptionPackage;

public class Badweather extends Exception {
	String exceptionname;
	   public Badweather(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }

}

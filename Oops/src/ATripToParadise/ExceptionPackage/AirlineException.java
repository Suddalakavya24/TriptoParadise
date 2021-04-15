package ATripToParadise.ExceptionPackage;

public class AirlineException extends Exception{
	
		String exceptionname;
	   public AirlineException(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }
	}



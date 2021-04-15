package ATripToParadise.ExceptionPackage;;

public class AirlinException extends Exception {
	String exceptionname;
   public AirlinException(String exceptionname){
	   super(exceptionname);
	   this.exceptionname=exceptionname;
   }
   public String toString() {
	   return this.exceptionname;
   }
}

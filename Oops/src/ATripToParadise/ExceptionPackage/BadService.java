package ATripToParadise.ExceptionPackage;;

public class BadService extends Exception{
	String exceptionname;
	   public BadService(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }
}

package ATripToParadise.ExceptionPackage;

public class PoorService extends Exception {
	String exceptionname;
	   public PoorService(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }

}

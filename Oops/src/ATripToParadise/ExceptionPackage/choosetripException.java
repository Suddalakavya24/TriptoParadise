package ATripToParadise.ExceptionPackage;

public class choosetripException extends Exception{
	String exceptionname;
	   public choosetripException(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }

}

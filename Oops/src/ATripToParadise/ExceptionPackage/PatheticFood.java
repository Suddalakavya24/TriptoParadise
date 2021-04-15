package ATripToParadise.ExceptionPackage;

public class PatheticFood extends Exception {
	String exceptionname;
	   public PatheticFood(String exceptionname){
		   super(exceptionname);
		   this.exceptionname=exceptionname;
	   }
	   public String toString() {
		   return this.exceptionname;
	   }

}

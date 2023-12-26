package T2_Lambdas_Gurinchi;

public class Example1 {
	
	@FunctionalInterface
	public interface DemoInterfaceNoArgs {
		public void printHello();
	}

	public static void main(String[] args) {
		
		DemoInterfaceNoArgs demoObj = () -> System.out.println("hello world");
		
		demoObj.printHello();

	}

}

package T2_Lambdas_Gurinchi;

public class Example2 {
	
	@FunctionalInterface
	public interface DemoInterfaceArgs {
		public void greet(String name);
	}

	public static void main(String[] args) {
		
		DemoInterfaceArgs demoObj = (name) -> System.out.println("Hi " + name);
		
		demoObj.greet("lipi-ganesh");

	}

}

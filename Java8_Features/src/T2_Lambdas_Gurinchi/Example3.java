package T2_Lambdas_Gurinchi;

public class Example3 {
	
	@FunctionalInterface
	public interface DemoInterfaceArgs1 { // without return type methods
		public void add(int n1, int n2);
	}
	
	public interface DemoInterfaceArgs2 { // with return type methods
		public int add(int n1, int n2);
	}

	public static void main(String[] args) {
		
		DemoInterfaceArgs1 demoObj1 = (n1, n2) -> System.out.println(n1+n2); 
		
		DemoInterfaceArgs2 demoObj2 = (n1, n2) ->  n1+n2; 
		
		demoObj1.add(1, 2);
		
		System.out.println(demoObj2.add(1, 2));

	}

}

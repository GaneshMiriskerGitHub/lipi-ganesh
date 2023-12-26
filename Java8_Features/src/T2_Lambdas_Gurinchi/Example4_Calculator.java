package T2_Lambdas_Gurinchi;

public class Example4_Calculator {

	@FunctionalInterface
	public interface DemoInterfaceCalcy {
		public int calculate(int n1, int n2);
	}

	public static void main(String[] args) {
		
		DemoInterfaceCalcy addObj = (n1, n2) ->  n1+n2;
		DemoInterfaceCalcy subObj = (n1, n2) ->  n1-n2;
		DemoInterfaceCalcy mulObj = (n1, n2) ->  n1*n2;
		DemoInterfaceCalcy divObj = (n1, n2) ->  n1/n2;
		
		System.out.println(addObj.calculate(1, 2));
		System.out.println(subObj.calculate(1, 2));
		System.out.println(mulObj.calculate(1, 2));
		System.out.println(divObj.calculate(1, 2));

	}

}

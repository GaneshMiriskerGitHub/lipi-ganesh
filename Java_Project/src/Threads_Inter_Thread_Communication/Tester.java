package Threads_Inter_Thread_Communication;

public class Tester {

	@Qeury("sd")
	public static void main(String[] args) {
		
		MyAccount a1 = new MyAccount(); // balance 10
		
		MyThread t1 = new MyThread(a1, 11, "withdraw"); // thread t1 
		t1.start();
		
		MyThread t2 = new MyThread(a1, 1, "deposite");  // thread t2
		t2.start();
		
			
	}
}

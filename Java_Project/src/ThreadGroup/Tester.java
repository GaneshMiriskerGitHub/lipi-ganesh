package ThreadGroup;

/*
 * 1. Create a thread group
 * 2. Create 3 threads
 * 3. assign a group for each thread
 * 
 *   ----------
 *   
 * 1. print the thread group's name
 * 2. print all the list of threads present inside a thread group
 * 
 */

public class Tester {

	public static void main(String[] args) {

		ThreadGroup t_group = new ThreadGroup("My_thread_group");

		
		MyThread obj = new MyThread(); // created by Runnable

		Thread t1 = new Thread(t_group,obj); 
		Thread t2 = new Thread(t_group,obj);
		Thread t3 = new Thread(t_group,obj);

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Name of my Group is : " + t_group.getName());
		
		t_group.list(); // group name and lists out all the threads inside it

	}
}

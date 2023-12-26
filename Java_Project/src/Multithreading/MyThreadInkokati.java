package Multithreading;

public class MyThreadInkokati extends Thread{
	
	public void run() {
		System.out.println("******************* :: "+ Thread.currentThread().getName());
	}

}

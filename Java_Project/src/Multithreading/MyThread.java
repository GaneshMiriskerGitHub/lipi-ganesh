package Multithreading;

public class MyThread extends Thread{
	
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName() + " started");
	}

}

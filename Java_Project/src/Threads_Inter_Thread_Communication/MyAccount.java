package Threads_Inter_Thread_Communication;

public class MyAccount {

	long balance = 10;
	
	public synchronized void withdraw(long dabbulu) { // 11
		System.out.println("Processing to WITH_DRAW .....");
		
		if(this.balance < dabbulu) {
			System.out.println("less balace waiting to deposite");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Emo Exception vachindi roiee");
			}
			
		}
		
		if(this.balance >= dabbulu) {
			this.balance -= dabbulu;
			System.out.println("WITH_DRAW is Completed  "+"current balance is : "+this.balance);
		}else {
			System.out.println("Cannot withdraw due to insufficient balance");
		}
		
	}
	
	public synchronized void deposite(long dabulu) {
		this.balance += dabulu;
		System.out.println("DEPOSITE is Completed  "+"current balance is : "+this.balance);
		notify();
	}
	
}

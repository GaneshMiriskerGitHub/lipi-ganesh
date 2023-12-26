package Threads_Inter_Thread_Communication;

public class MyThread extends Thread{
	
	MyAccount account;
	long money;
	String with_depo;
	
	public MyThread(MyAccount a1 , long money, String with_depo) {
		this.account = a1;
		this.money = money;
		this.with_depo = with_depo;
	}
	
	public void run() {
		if(this.with_depo == "withdraw") {
			account.withdraw(money);
		}else {
			account.deposite(money);
		}
	}

}

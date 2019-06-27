

public class AccountThreads implements Runnable {
	
		private AccountDemo acct = new AccountDemo();
		
		public static void main (String [] args) {
		
		AccountThreads r = new AccountThreads();
		
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		
		one.setName("Husband");
		two.setName("Wife");
		
		one.start();
		two.start();

		}
		
		@Override
		public void run() {

			makeWithdrawal(1000);			
		}
		
		private synchronized void makeWithdrawal(int amt) {
			
			if (acct.getBalance() >= amt) {
				
				System.out.println(Thread.currentThread().getName()
						+ " is going to withdraw Balance is :"+
						acct.getBalance());
				
				acct.withdraw(amt);
				
				System.out.println(Thread.currentThread().getName()
						+ " completes the withdrawal Now Balance becomes : "+
						acct.getBalance());
			}else{
				
				System.out.println("Not enough in account for "
						+ Thread.currentThread().getName()
						+ " to withdraw " + acct.getBalance());
			}
		}
}

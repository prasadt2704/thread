class MyThread extends Thread {

	@Override
	public void run() {
		for (int i =1; i < 3; i++) {
			System.out.println(i + "\t" + Thread.currentThread().getName() );
		}
	}

}

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		//t1.setPriority(11);
		t1.start();
		MyThread t2 = new MyThread();
		t2.start();
		
		
		for (int i =1; i < 3; i++) {
			System.out.println(i + "\t" + Thread.currentThread().getPriority() );
		}
	

	}

}

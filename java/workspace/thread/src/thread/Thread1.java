package thread;

public class Thread1 extends Thread {
	private String data;
	
	public Thread1() {;}
	
	public Thread1(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		// run() 메소드 안에 작성한 소스코드가 멀티 쓰레드의 자원이 됨
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {sleep(1000);} catch (InterruptedException e) {;}
		}
	}
	
}

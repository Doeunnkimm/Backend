package access1;

public class Variable {
	int data1; // 안 쓰면 기본적으로 default 
	public int data2;
	protected int data3;
	private int data4;
	
	public Variable() {;}
	
//	private를 다른 데에서 접근시키고 싶을 때
	public Variable(int data4) {
		this.data4 = data4;
	}
	
	public int getData4() {
		return this.data4;
	}
}

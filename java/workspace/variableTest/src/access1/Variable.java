package access1;

public class Variable {
	int data1; // �� ���� �⺻������ default 
	public int data2;
	protected int data3;
	private int data4;
	
	public Variable() {;}
	
//	private�� �ٸ� ������ ���ٽ�Ű�� ���� ��
	public Variable(int data4) {
		this.data4 = data4;
	}
	
	public int getData4() {
		return this.data4;
	}
}

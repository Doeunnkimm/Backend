package abstractTest;

public abstract class Electronics {
	// ������ ������ �ض�
	public abstract void on(); // �߻� �޼ҵ�
	public abstract void off(); 
	
	// ����� �ض�
	public void printProduct() {}; // �Ϲ� �޼ҵ�
	
	// ������ ��������
	public final void sos() {System.out.println("�����ȭ 119 ����");}
}

package anonymousTest;

// ����
public class Starbucks {
	// register �Ű������� ���� ��
	// Form Ÿ���̶�� sell�� �ִ� �����̰�
	// FormAdapter Ÿ���̶�� sell�� ���� ������
	public void register(Form form) { // ������ ����ϴ� �޼ҵ�
		// ����� �Ϸ��� ���翡 form�� �����ؾ� ��
		String[] menu = form.getMenu();
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		
		if(form instanceof FormAdapter) {
			System.out.println("���� ���� �����Դϴ�.");
			return; // �޼ҵ� �ٷ� Ż��
		}
		form.sell("�Ƹ޸�ī��");
	}
}

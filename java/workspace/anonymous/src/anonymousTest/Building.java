package anonymousTest;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks(); // ������
		Starbucks jamsil = new Starbucks(); // �����
		
		jamsil.register(new FormAdapter() {
			// ����� ���ᳪ���� �Ѵ�.
			// sell �޼ҵ�� �ʿ� ����
			// -> ��� �������ؾ� �ϴ� ��Ȳ
			// �׷��� Form �������̽����� sell �޼ҵ尡 ����
			// Adapter �������
			
			@Override
			public String[] getMenu() {
				return new String[] {"�Ƹ޸�ī��", "ī���", "��ü��"};
			}
		});

		// �������� �����ؾ� �ϴ� ������ �ٸ� �״ϱ�
		// �͸� Ŭ������ �ٷ� ����
		gangnam.register(new Form() {
			
			@Override
			public void sell(String order) {
				String[] menu = getMenu();
				for (int i = 0; i < menu.length; i++) {
					if(menu[i].equals(order)) {
						System.out.println(order + " �ֹ� �Ϸ�");
						return; // ������ ��� �޼ҵ� ����
					}
				}
				System.out.println("���� �޴��Դϴ�.");
			}
			
			@Override
			public String[] getMenu() {
				// ���������� �� �޴� ����
				return new String[] {"�Ƹ޸�ī��", "ī���", "�׸�Ƽ"};
			}
		});
	}
}

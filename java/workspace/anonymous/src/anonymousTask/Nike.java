package anonymousTask;

public class Nike {
	
	public void regist(Form form) {
		
		String[] items = form.sellItemList();
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
		
		if(form instanceof FormAdapter) {
			System.out.println("���� ���� �����Դϴ�.");
			return;
		}
		form.sell("�Ź�");
	}
	

}

package anonymousTask;

public class Building {
	public static void main(String[] args) {
		
		Nike gangnam = new Nike();
		Nike jamsil = new Nike();
		
		jamsil.regist(new FormAdapter() {
			
			@Override
			public String[] sellItemList() {
				return new String[] {"�Ź�", "�縻", "����", "��ȭ"};
			}
			
		});
		
		gangnam.regist(new Form() {
			
			@Override
			public String[] sellItemList() {
				return new String[] {"�Ź�",  "������", "�ĵ�Ƽ", "����"}; 
			}
			
			@Override
			public void sell(String order) {
				System.out.println(order + " �ǸŵǾ����ϴ�.");
				
			}
		});
	}
}

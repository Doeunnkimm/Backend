package anonymousTask;

public class Building {
	public static void main(String[] args) {
		
		Nike gangnam = new Nike();
		Nike jamsil = new Nike();
		
		jamsil.regist(new FormAdapter() {
			
			@Override
			public String[] sellItemList() {
				return new String[] {"신발", "양말", "반팔", "농구화"};
			}
			
		});
		
		gangnam.regist(new Form() {
			
			@Override
			public String[] sellItemList() {
				return new String[] {"신발",  "맨투맨", "후드티", "가방"}; 
			}
			
			@Override
			public void sell(String order) {
				System.out.println(order + " 판매되었습니다.");
				
			}
		});
	}
}

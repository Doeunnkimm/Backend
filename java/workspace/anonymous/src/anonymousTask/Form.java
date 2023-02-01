package anonymousTask;

public interface Form {
	// 새로운 매장이 매장 등록을 위해
	// 본사에 제출해야 할 양식을 인터페이스로 정의
	
	public String[] sellItemList(); // 판매할 아이템
	public void sell(String order); // 판매 메소드
}

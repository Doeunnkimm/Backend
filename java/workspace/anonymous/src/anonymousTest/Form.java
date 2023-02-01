package anonymousTest;

// 지점들이 등록을 위해
// 제출해야 하는 양식을 정해주는 것
public interface Form {
	public String[] getMenu(); // 본사 메뉴판
	public void sell(String order);
}

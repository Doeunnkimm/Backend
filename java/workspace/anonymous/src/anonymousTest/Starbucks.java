package anonymousTest;

// 본사
public class Starbucks {
	// register 매개변수로 들어온 게
	// Form 타입이라면 sell이 있는 메장이고
	// FormAdapter 타입이라면 sell이 없는 매장임
	public void register(Form form) { // 지점이 등록하는 메소드
		// 등록을 하려면 본사에 form을 제출해야 함
		String[] menu = form.getMenu();
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		
		if(form instanceof FormAdapter) {
			System.out.println("무료 나눔 매장입니다.");
			return; // 메소드 바로 탈출
		}
		form.sell("아메리카노");
	}
}

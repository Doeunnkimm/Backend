package anonymousTest;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks(); // 강남점
		Starbucks jamsil = new Starbucks(); // 잠실점
		
		jamsil.register(new FormAdapter() {
			// 잠실은 무료나눔을 한다.
			// sell 메소드는 필요 없음
			// -> 골라서 재정의해야 하는 상황
			// 그런데 Form 인터페이스에는 sell 메소드가 있음
			// Adapter 사용하자
			
			@Override
			public String[] getMenu() {
				return new String[] {"아메리카노", "카페라떼", "돌체라떼"};
			}
		});

		// 지점마다 구현해야 하는 내용이 다를 테니까
		// 익명 클래스로 바로 구현
		gangnam.register(new Form() {
			
			@Override
			public void sell(String order) {
				String[] menu = getMenu();
				for (int i = 0; i < menu.length; i++) {
					if(menu[i].equals(order)) {
						System.out.println(order + " 주문 완료");
						return; // 만나는 즉시 메소드 종료
					}
				}
				System.out.println("없는 메뉴입니다.");
			}
			
			@Override
			public String[] getMenu() {
				// 강남점에서 팔 메뉴 종류
				return new String[] {"아메리카노", "카페라떼", "그린티"};
			}
		});
	}
}

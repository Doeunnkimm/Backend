package classTest;

class Market {
	String name;
	int price;
	int stock;
	
	public Market() {;}

	public Market(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	void sell(Customer customer) {
		customer.money -= this.price * ((100 - customer.discount) * 0.01);
		stock--;
	}
}

class Customer {
	String name;
	String phoneNumber;
	int money;
	int discount;
	
	public Customer() {;}

	public Customer(String name, String phoneNumber, int money, int discount) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.discount = discount;
	}

}

public class ClassTask3 {
	public static void main(String[] args) {
		Market market = new Market("»õ¿ì±ø", 1800, 50);
		Customer[] arcustomer = {
				new Customer("ÇÑµ¿¼®", "01022223333", 10_000, 50),
				new Customer("È«±æµ¿", "01022223333", 1000, 70)
		};
		
		for (int i = 0; i < arcustomer.length; i++) {
			market.sell(arcustomer[i]); // ÇÑµ¿¼®´ÔÀÌ 50% ÇÒÀÎÀ²À¸·Î 1800¿ø »õ¿ì±øÀ» »òÀ½
			System.out.print(arcustomer[i].name + "´ÔÀÇ ÀÜ°í: ");
			System.out.println(arcustomer[i].money); // ÇÑµ¿¼®´ÔÀÌ 900¿øÀ¸·Î »õ¿ì±øÀ» »ç°í³­ ÈÄ ÀÌ¹Ç·Î ÀÜ¾×Àº 9100¿ø
		}
	}
}

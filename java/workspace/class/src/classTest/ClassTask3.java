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
		Market market = new Market("�����", 1800, 50);
		Customer[] arcustomer = {
				new Customer("�ѵ���", "01022223333", 10_000, 50),
				new Customer("ȫ�浿", "01022223333", 1000, 70)
		};
		
		for (int i = 0; i < arcustomer.length; i++) {
			market.sell(arcustomer[i]); // �ѵ������� 50% ���������� 1800�� ������� ����
			System.out.print(arcustomer[i].name + "���� �ܰ�: ");
			System.out.println(arcustomer[i].money); // �ѵ������� 900������ ������� ��� �� �̹Ƿ� �ܾ��� 9100��
		}
	}
}

package bank;

public class KaKao extends Bank {
	@Override
	public void deposit(int money) {
		this.money /= 2;
		super.deposit(money);
	}
}

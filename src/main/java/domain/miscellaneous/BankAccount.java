package domain.miscellaneous;

public class BankAccount {
	private String accountId;
	private Address address;

	public BankAccount(String accountId, Address address) {
		this.accountId = accountId;
		this.address = address;
	}

	public void update(Address address) {
		this.address = address;
	}
}

package domain.miscellaneous;

import java.util.List;
import java.util.UUID;

public class Customer {
	private Address address;
	private List<BankAccount> bankAccounts;
	private UUID id;

	public Customer(Address address, List<BankAccount> bankAccounts) {
		this.address = address;
		this.bankAccounts = bankAccounts;
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void update(Address address) {
		this.address = address;
		bankAccounts.forEach(bankAccount -> bankAccount.update(address));
	}
}

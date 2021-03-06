package domain.miscellaneous;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Bank {
	private final HashMap<UUID, List<BankAccount>> customerAccounts;

	public Bank(HashMap<UUID, List<BankAccount>> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}

	public void update(Customer customer, Address address) {
		if (customerAccounts.containsKey(customer.getId())) {
			List<BankAccount> bankAccounts = customerAccounts.get(customer.getId());
			customer.update(address);
			bankAccounts.forEach(bankAccount -> bankAccount.update(address));
		}
	}

}

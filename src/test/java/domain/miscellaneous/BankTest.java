package domain.miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

class BankTest {
	@Test
	void shouldUpdateAddress() {
		HashMap<UUID, List<BankAccount>> customerAccounts = new HashMap<>();

		Address address = new Address("India", "foo");
		customerAccounts.put(UUID.randomUUID(), List.of(new BankAccount("AC1234", address)));

		Bank bank = new Bank(customerAccounts);
		Address updatedAddress = new Address("UK", "foo");

//		Customer customer = new Customer(address, bankAccounts);

//		customer.update(address);
//		bank.update(customer, updatedAddress);
	}
}

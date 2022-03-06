/*
 * Grayson Capko
 * 3/6/2022
 */
package Contact_Pack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

	ContactManager contactManager; 
	
	@BeforeAll
	public void setupAll() {
		System.out.println("This Print Before All Test");
	}
	
	@BeforeEach
	public void setup() {
		contactManager = new ContactManager();
	}
	
	@Test
	public void shouldCreateContact() {
	
		contactManager.addContact("John","Doe", "5123456789");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1,  contactManager.getAllContacts().size());
		Assertions.assertTrue(contactManager.getAllContacts().stream()
				.filter(contact -> contact.getFirstName().equals("John") &&
						contact.getLastName().equals("Doe") &&
						contact.getPhoneNumber().equals("0123456789"))
				.findAny()
				.isPresent());
	}
	
	@Test
	@DisplayName("Should Not Create Contact When First Name is NULL")
	public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
		
		Assertions.assertThrows(RuntimeException.class, () ->{
			contactManager.addContact(null, "Doe", "0123456789");
		});
	}

	@Test
	@DisplayName("Should Not Create Contact When Last Name is NULL")
	public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
	
		Assertions.assertThrows(RuntimeException.class, () ->{
			contactManager.addContact("John", null, "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should Not Create Contact When Phone Number is NULL")
	public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
		Assertions.assertThrows(RuntimeException.class, () ->{
			contactManager.addContact("John", "Doe", null);
		});
	}
	
	@DisplayName("Repeat Contact Creation Test 5 Times")
	@ParameterizedTest
	@ValueSource(strings = {"2123456789", "1876543210", "1234567894"})
	public void shouldTestContactCreationUsingValueSource(String phoneNumber) {
		contactManager.addContact("John", "Doe", phoneNumber);
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("Should Execute After Each Test");
	}
	
	@AfterAll
	public void tearDownAll() {
		System.out.println("Should be Executed at the end of the Test");
	}
}

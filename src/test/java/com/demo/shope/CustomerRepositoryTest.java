package com.demo.shope;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.demo.shope.entity.Customer;
import com.demo.shope.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTest {
        
	@Autowired
	private CustomerRepository repo;
	
 //Just to make dummy customer entries.
	@Test
	public void testCreateCustomer() {
		
		Customer customer=new Customer("Aniruddha","8/2/98 Arabinda Sarani,DumDum");
	    Customer savedCustomer=repo.save(customer);
	    assertThat(savedCustomer.getId()).isGreaterThan(0);
	}
	
	//Test to check the logic that only unique people are inserted.[uniqueness depends on name]
	@Test
	public void testInsertCustomerByUniqueName() {
		
		Customer customer=new Customer("Aniruddha","8/2/98 Arabinda Sarani,DumDum");
	    Customer customerAlreadyPresent=repo.findByName(customer.getName());
		Customer savedCustomer=null;
	    if(customerAlreadyPresent==null) {
			savedCustomer=repo.save(customer);
		}
	    assertThat(savedCustomer).isEqualTo(null);
	}
	
	//Test to see the list of customers.
	@Test 
	public void testListAllCustomers() {
		Iterable<Customer> customerList= repo.findAll();
		customerList.forEach(System.out::println);
	}
	
	
}

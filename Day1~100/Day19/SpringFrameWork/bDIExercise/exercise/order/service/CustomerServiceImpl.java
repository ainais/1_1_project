package exercise.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;
import exercise.order.repository.CustomerRepositoryImpl;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	
	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}


	@Override
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}


	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}

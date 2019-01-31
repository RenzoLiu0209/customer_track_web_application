package renzo.work.project.service;

import java.util.List;

import renzo.work.project.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	public Customer getCustomerById(int theId);
	public void saveCustomer(Customer newCustomer);
	public void deleteCustomerById(int theId);
}

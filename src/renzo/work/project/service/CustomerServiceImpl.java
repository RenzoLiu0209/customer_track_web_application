package renzo.work.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import renzo.work.project.DAO.CustomerDAO;
import renzo.work.project.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
 
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer newCustomer) {
		
		customerDAO.saveCustomer(newCustomer);
	}
	
	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		
		return customerDAO.getCustomerById(theId);
	}
	
	@Override
	@Transactional
	public void deleteCustomerById(int theId) {
		
		customerDAO.deleteCustomerById(theId);
	}
}

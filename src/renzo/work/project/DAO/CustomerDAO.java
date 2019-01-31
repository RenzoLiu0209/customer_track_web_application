package renzo.work.project.DAO;

import java.util.List;
import renzo.work.project.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	Customer getCustomerById(int theId);
	void saveCustomer(Customer customer);
	public void deleteCustomerById(int theId);
}

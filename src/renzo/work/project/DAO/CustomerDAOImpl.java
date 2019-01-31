package renzo.work.project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import renzo.work.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		// sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
		return query.getResultList();
	}
	
	@Override
	public void saveCustomer(Customer newCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(newCustomer);
	}
	
	@Override
	public Customer getCustomerById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class,theId);
		return theCustomer;
	}
	
	@Override
	public void deleteCustomerById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		//Query theQuery = 
				//currentSession.createQuery("delete from Customer where id=:customerId");
		//theQuery.setParameter("customerId",theId);
		//theQuery.executeUpdate()
		Customer theCustomer = currentSession.get(Customer.class,theId);
		currentSession.delete(theCustomer);
	}
}

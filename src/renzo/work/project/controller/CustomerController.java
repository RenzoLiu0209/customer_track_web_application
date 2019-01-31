package renzo.work.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import renzo.work.project.entity.Customer;
import renzo.work.project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject the customer Service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind from data
		model.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustoner(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model){
		
		// get the customer from the database
		Customer theCustomer = customerService.getCustomerById(theId);
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer",theCustomer);
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteById(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomerById(theId);
		return "redirect:/customer/list";
	}
}

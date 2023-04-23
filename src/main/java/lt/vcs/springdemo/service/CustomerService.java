package lt.vcs.springdemo.service;

import lt.vcs.springdemo.repository.Customer;
import lt.vcs.springdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

@Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        if (customerRepository.findById(id).isPresent()) {
            return customerRepository.findById(id).get();
        }
        return new Customer();
    }

    public Customer getCustomerByIdCustomised(int id) {
        if (customerRepository.findById(id).isPresent()) {
            return customerRepository.findByCustomerNumber(id).get();
        }
        return new Customer();
    }

    public List<Customer> getCustomersByNameLike(String name) {
        return (List<Customer>) customerRepository.findByCustomerNameLike(name);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.getCustomersByName(name);
    }
}

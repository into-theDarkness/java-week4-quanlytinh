package tranminhduc.pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tranminhduc.pro.model.Customer;
import tranminhduc.pro.repository.CustomerRepository;
import tranminhduc.pro.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
    @Override
    public Customer findById(Long id){
        return customerRepository.findOne(id);
    }
    @Override
    public void save(Customer customer){
        customerRepository.save(customer);
    }
    @Override
    public void remove(Long id){
        customerRepository.delete(id);
    }
}


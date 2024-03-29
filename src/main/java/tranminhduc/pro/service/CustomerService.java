package tranminhduc.pro.service;

import tranminhduc.pro.model.Customer;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();
    Customer findById(Long id);
    void save (Customer customer);
    void remove (Long id);

}

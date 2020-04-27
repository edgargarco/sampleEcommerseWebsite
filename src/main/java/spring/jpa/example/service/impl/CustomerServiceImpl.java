package spring.jpa.example.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.jpa.example.model.Customer;
import spring.jpa.example.repository.CustomerRepository;
import spring.jpa.example.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Log log = LogFactory.getLog(CustomerServiceImpl.class);

    private CustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findOne(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer find(Customer entity) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> create(Customer entity) {
        Customer customer =  customerRepository.findByEmail(entity.getEmail());

        if (customer == null){
            customerRepository.save(entity);
           return Optional.ofNullable(entity);
        }else {
            log.info("Entity with email "+entity.getEmail()+" already exist");
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void delete(Customer entity) {

    }

    @Override
    public void deleteById(long entityId) {
    }
    public Customer findByConfirmationToker(String confirmation){
        return customerRepository.findByConfirmationToken(confirmation);
    }

    public Customer findByEmailAndPassword(String email, String password){
        return customerRepository.findByEmailAndPassword(email,password);
    }


}

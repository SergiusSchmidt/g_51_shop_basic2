package app.service;

import app.domain.Customer;
import app.exceptions.CustomerNotFoundException;
import app.exceptions.CustomerSaveException;
import app.exceptions.CustomerUpdateException;
import app.exceptions.ProductNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer) throws CustomerSaveException;
    List<Customer> getAllActiveCustomers();
    Customer getActiveCustomerById(Long id) throws CustomerNotFoundException;
    void updateActiveCustomer(Customer customer) throws CustomerUpdateException, CustomerNotFoundException;
    void deleteById(Long id) throws CustomerNotFoundException;
    void deleteByName(String name);
    void restoreById(Long id);
    int getActiveCustomersNumber();
    double getCustomersCartTotalPrice(Long id) throws CustomerNotFoundException;
    double getCustomersCartAveragePrice(Long id) throws CustomerNotFoundException;
    void addProductToCustomersCart(Long customerId, Long productId) throws CustomerNotFoundException, ProductNotFoundException;
    void deleteProductFromCustomersCart(Long customerId, Long productId) throws CustomerNotFoundException;
    void clearCustomersCart(Long id) throws CustomerNotFoundException;
}
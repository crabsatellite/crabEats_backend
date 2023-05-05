package com.crab.onlineOrder.service;

import com.crab.onlineOrder.dao.CustomerDao;
import com.crab.onlineOrder.entity.Cart;
import com.crab.onlineOrder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {


    private CustomerDao customerDao;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public CustomerService(CustomerDao customerDao, PasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.passwordEncoder = passwordEncoder;
    }


    public void signUp(Customer customer) throws Exception {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        try {
            customerDao.signUp(customer);
        } catch (Exception ex) {
            throw ex;
        }
    }



    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }


}

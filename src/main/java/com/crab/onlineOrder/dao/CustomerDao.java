package com.crab.onlineOrder.dao;


import com.crab.onlineOrder.entity.Authorities;
import com.crab.onlineOrder.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDao {


    @Autowired
    private SessionFactory sessionFactory;


    public void signUp(Customer customer) throws Exception {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            // check if the email has been registered
            Customer customer1 = session.get(Customer.class, customer.getEmail());
            if (customer1 != null) {
                throw new Exception("This email has been registered");
            }
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session != null) session.getTransaction().rollback();
            throw ex; // 将异常抛出，以便在 CustomerService 中处理
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    public Customer getCustomer(String email) {
        Customer customer = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }


}

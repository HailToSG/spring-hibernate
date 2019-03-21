package com.itc.customertracker.dao;

import com.itc.customertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private Session session;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer", Customer.class);
        return customerQuery.getResultList();
    }
}
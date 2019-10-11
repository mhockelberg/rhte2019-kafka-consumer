package org.mycompany;

import java.util.Collection;
import java.util.Optional;
import org.mycompany.*;


/**
 * Service interface for managing customers.
 */
public interface CustomerService {

    /**
     * Find a customer by the given ID
     *
     * @param id
     *            the ID of the customer
     * @return the customer, or <code>null</code> if customer not found.
     */
	Customers findCustomer(Integer id);

    /**
     * Find all customers
     *
     * @return a collection of all customers
     */
    Iterable <Customers> findCustomers();

    /**
     * Update the given customer
     *
     * @param customer
     *            the customer
     */
    void updateCustomer(Customers customer);
    
    /**
     * Update the given customer
     *
     * @param change event from debezium
     *            
     */
    Customers updateCustomerWithChangeEvent(ChangeEvent changeEvent);

}
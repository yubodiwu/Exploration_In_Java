package com.mycompany.controller;

import com.mycompany.model.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;
import com.mycompany.model.CustomerJDBCTemplate;

import java.util.List;

/**
 * Created by yubodiwu on 1/11/17.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    CustomerJDBCTemplate customerJDBCTemplate = (CustomerJDBCTemplate)context.getBean("customerJDBCTemplate");

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> addCustomer(@RequestBody Customer customer) {
        System.out.println("post hit");
        List<Customer> customers = getAllCustomers();

        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                System.out.println("already in list");
                return customers;
            }
        }

        customerJDBCTemplate.create(customer.getName(), customer.getId());
        customers = getAllCustomers();

        return customers;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getAllCustomers() {
        System.out.println("index hit");

        List<Customer> customers = customerJDBCTemplate.listCustomers();

        return customers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getCustomerById(@PathVariable("id") Long id) {
        System.out.println("get hit");

        List<Customer> customer = customerJDBCTemplate.getCustomer(id);

        return customer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody String name) {
        System.out.println("create hit");

        customerJDBCTemplate.update(id, name);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean deleteCustomer(@RequestBody Long id) {
        System.out.println("delete hit");

        List<Customer> delCustomer = getCustomerById(id);

        if (delCustomer.size() == 0) {
            return false;
        } else {
            customerJDBCTemplate.delete(id);

            return true;
        }
    }
}

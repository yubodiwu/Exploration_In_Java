package com.mycompany.controller;

import com.mycompany.model.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubodiwu on 1/11/17.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static List<Customer> list = new ArrayList<Customer>();

    static {
        list.add(new Customer(1l, "Johny Johny"));
        list.add(new Customer(2l, "Tommy Tommy"));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> addCustomer(@RequestBody Customer customer) {
        System.out.println("post hit");
        for (Customer c : list) {
            if (c.getId() == customer.getId()) {
                System.out.println("already in list");
                return list;
            }
        }

        list.add(customer);
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getAllCustomers() {
        System.out.println("index hit");
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") Long id) {
        System.out.println("get hit");

        for (Customer c : list) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody String name) {
        System.out.println("create hit");

        for (Customer c : list) {
            if (c.getId() == id) {
                c.setName(name);
            }
        }
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteCustomer(@RequestBody Long id) {
        System.out.println("delete hit");
        Customer delCustomer = null;

        for (Customer customer : list) {
            if (customer.getId() == id) {
                delCustomer = customer;
            }
        }

        if (delCustomer == null) {
            System.out.println("id does not exist");
        } else {
            list.remove(delCustomer);
        }
    }
}

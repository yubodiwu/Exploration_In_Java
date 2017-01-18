package com.mycompany.model;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;
/**
 * Created by yubodiwu on 1/13/17.
 */
public class CustomerJDBCTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, Long id) {
        String SQL = "insert into customers (name, id) values (?, ?)";

        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Created Record Name = " + name +  " id = " + id);
    }

    public List<Customer> getCustomer(Long id) {
        String SQL = String.format("select * from customers where id = '%s'", id);
        List<Customer> customer = jdbcTemplateObject.query(SQL, new CustomerMapper());

        return customer;
    }

    public List<Customer> listCustomers() {
        String SQL = "select * from customers";
        List<Customer> customers = jdbcTemplateObject.query(SQL, new CustomerMapper());

        return customers;
    }

    public void update(Long id, String name) {
        String SQL = String.format("update customers set name = '%s' where id = '%s'", name, id);
        jdbcTemplateObject.update(SQL);
    }

    public void delete(Long id) {
        String SQL = String.format("delete from customers where id = '%s'", id);
        jdbcTemplateObject.update(SQL);

        System.out.println("Deleted Record with ID = " + id);
    }
}

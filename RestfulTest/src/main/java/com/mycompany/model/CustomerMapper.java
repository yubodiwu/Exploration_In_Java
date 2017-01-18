package com.mycompany.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by yubodiwu on 1/13/17.
 */
public class CustomerMapper implements RowMapper<Customer>{
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId((long) (rs.getInt("id")));
        customer.setName(rs.getString("name"));

        return customer;
    }
}

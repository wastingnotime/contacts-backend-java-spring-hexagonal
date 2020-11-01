package com.henriquericcio.contacts.adapters.api.query;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        return new Contact(rs.getString("ID"),
                rs.getString("FIRSTNAME"),
                rs.getString("PHONENUMBER"),
                rs.getString("LASTNAME"));
    }
}

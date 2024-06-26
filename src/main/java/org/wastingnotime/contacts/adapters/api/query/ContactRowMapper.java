package org.wastingnotime.contacts.adapters.api.query;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        return new Contact(rs.getString("id"),
                rs.getString("first_name"),
                rs.getString("phone_number"),
                rs.getString("last_name"));
    }
}

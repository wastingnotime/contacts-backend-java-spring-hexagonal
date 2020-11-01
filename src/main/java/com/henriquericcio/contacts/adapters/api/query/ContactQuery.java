package com.henriquericcio.contacts.adapters.api.query;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ContactQuery {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Contact> mapper;

    public Iterable<Contact> findAll() {
        return jdbcTemplate.query("SELECT * FROM CONTACT", mapper);
    }

    public Optional<Contact> findById(String id) {
        try{
            return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM CONTACT WHERE ID = ?", new Object[]{id}, mapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}

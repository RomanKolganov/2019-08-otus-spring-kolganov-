package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDAOJdbc implements AuthorDAO {
    private final NamedParameterJdbcOperations jdbcOperations;

    public AuthorDAOJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Author> findAll() {
        return jdbcOperations.query("select * from authors", new AuthorMapper());
    }

    @Override
    public Author findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("select * from authors where id = :id", params, new AuthorMapper());
    }

    @Override
    public void create(Author author) {
        Map<String, Object> params = Collections.singletonMap("name", author.getName());
        jdbcOperations.update("insert into authors (`name`) values (:name)", params);
    }

    @Override
    public void update(Author author) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("name", author.getName());

        jdbcOperations.update("update authors set name = :name where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update("delete from authors where id = :id", params);
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");

            return new Author(id, name);
        }
    }
}

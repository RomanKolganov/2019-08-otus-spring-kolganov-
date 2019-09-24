package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;
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
public class GenreDAOJdbc implements GenreDAO {
    private final NamedParameterJdbcOperations jdbcOperations;

    public GenreDAOJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Genre> findAll() {
        return jdbcOperations.query("select * from genres", new GenreMapper());
    }

    @Override
    public Genre findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("select * from genres where id = :id", params, new GenreMapper());
    }

    @Override
    public void create(Genre genre) {
        Map<String, Object> params = Collections.singletonMap("name", genre.getName());
        jdbcOperations.update("insert into genres (`name`) values (:name)", params);
    }

    @Override
    public void update(Genre genre) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("name", genre.getName());

        jdbcOperations.update("update genres set name = :name where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update("delete from genres where id = :id", params);
    }

    private static class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}

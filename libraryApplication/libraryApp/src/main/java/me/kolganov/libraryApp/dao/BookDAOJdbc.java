package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
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
public class BookDAOJdbc implements BookDAO {
    private final NamedParameterJdbcOperations jdbcOperations;

    public BookDAOJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Book> findAll() {
        return jdbcOperations.query("select b.*, a.name as author_name, g.name as genre_name from books b " +
                "left join authors a on a.id = b.author_id " +
                "left join genres g on g.id = b.genre_id", new BookMapper());
    }

    @Override
    public Book findById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("select b.*, a.name as author_name, g.name as genre_name from books b " +
                "left join authors a on a.id = b.author_id " +
                "left join genres g on g.id = b.genre_id " +
                "where b.id = :id", params, new BookMapper());
    }

    @Override
    public void create(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", book.getName());
        params.put("author_id", book.getAuthor().getId());
        params.put("genre_id", book.getGenre().getId());

        jdbcOperations.update("insert into books (name, author_id, genre_id) values(:name, :author_id, :genre_id", params);
    }

    @Override
    public void updateName(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());

        jdbcOperations.update("update books set name = :name where id = :id", params);
    }

    @Override
    public void updateAuthor(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("author_id", book.getAuthor().getId());

        jdbcOperations.update("update books set author_id = :author_id where id = :id", params);
    }

    @Override
    public void updateGenre(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("genre_id", book.getGenre().getId());

        jdbcOperations.update("update books set genre_id = :genre_id where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update("delete from books where id = :id", params);
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long authorId = resultSet.getLong("author_id");
            long genreId = resultSet.getLong("genre_id");
            String authorName = resultSet.getString("author_name");
            String genreName = resultSet.getString("genre_name");

            return new Book(id, name, new Author(authorId, authorName), new Genre(genreId, genreName));
        }
    }
}

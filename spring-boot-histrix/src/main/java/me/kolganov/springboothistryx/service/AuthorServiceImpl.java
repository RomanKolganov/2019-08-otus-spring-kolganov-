package me.kolganov.springboothistryx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.dao.AuthorDAO;
import me.kolganov.springboothistryx.domain.Author;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO dao;

    @HystrixCommand(commandKey="getRentsKey", fallbackMethod="buildFallbackRents")
    @Override
    public List<Author> getAll() {
        return dao.findAll();
    }

    @Override
    public Author getById(long id) {
        return dao.findById(id).orElseGet(Author::new);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    @PreAuthorize("hasPermission(#author, 'write') or " +
            "hasRole('ADMIN')")
    public void update(@Param("author") Author author) {
        Optional<Author> oldAuthor = dao.findById(author.getId());
        oldAuthor.ifPresent(a -> {
            a.setName(author.getName());
            dao.save(a);
        });
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(long id) {
        dao.deleteById(id);
    }

//    public List<Author> buildFallbackRents(String animal) {
//        Author rent = new Author();
//        rent.setId(0L);
//        rent.setAnimal(animal);
//        rent.setCustomer("N/A");
//        rent.setStartDate("N/A");
//        rent.setEndDate("N/A");
//        List<Rent> rents = new ArrayList<>();
//        rents.add(rent);
//        return rents;
//    }
}

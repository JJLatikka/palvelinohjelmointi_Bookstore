package bookstore.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import bookstore.domain.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}

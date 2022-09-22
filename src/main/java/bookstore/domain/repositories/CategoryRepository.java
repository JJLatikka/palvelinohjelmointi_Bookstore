package bookstore.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bookstore.domain.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByName(String name);

}

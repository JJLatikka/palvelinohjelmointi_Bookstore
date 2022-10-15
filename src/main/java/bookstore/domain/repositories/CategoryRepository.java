package bookstore.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import bookstore.domain.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public Category findByName(String n);

}

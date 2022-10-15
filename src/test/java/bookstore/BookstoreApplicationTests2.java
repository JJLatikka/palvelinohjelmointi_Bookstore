package bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.domain.entities.Category;
import bookstore.domain.repositories.CategoryRepository;

@SpringBootTest
public class BookstoreApplicationTests2 {

	@Autowired
	private CategoryRepository cRepo;

	private List<Category> cL = Arrays.asList(new String[] { "Test0", "Test1", "Test2", "Test3" }).stream()
			.map(s -> new Category(s)).toList();

	@BeforeEach
	public void beforeEach() {
		cRepo.deleteAll();
	}

	@Test
	public void saveCategoryTest() {
		cRepo.save(cL.get(0));
		assertThat(cRepo.findByName("Test0")).isNotNull();
	}

	@Test
	public void deleteCategoryTest() {
		Long id = cRepo.save(cL.get(0)).getId();
		cRepo.deleteById(id);
		assertThat(cRepo.findByName("Test0")).isNull();
	}

	@Test
	public void findOneCategoryTest() {
		Long id = cRepo.save(cL.get(0)).getId();
		assertThat(cRepo.findById(id).isPresent());
	}

	@Test
	public void findAllCategories() {
		cL.forEach(cRepo::save);
		List<Category> l = new ArrayList<>();
		cRepo.findAll().forEach(l::add);
		assertEquals(l.size(), 4);
	}

}

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

import bookstore.domain.entities.AppUser;
import bookstore.domain.repositories.AppUserRepository;

@SpringBootTest
public class BookstoreApplicationTests3 {

	@Autowired
	private AppUserRepository aURepo;

	private List<AppUser> aUL = Arrays.asList(new String[] { "Test0", "Test1", "Test2", "Test3" }).stream()
			.map(s -> new AppUser(s, s, s)).toList();

	@BeforeEach
	public void beforeEach() {
		aURepo.deleteAll();
	}

	@Test
	public void saveUserTest() {
		aURepo.save(aUL.get(0));
		assertThat(aURepo.findByUsername("Test0")).isNotNull();
	}

	@Test
	public void deleteUserTest() {
		Long id = aURepo.save(aUL.get(0)).getId();
		aURepo.deleteById(id);
		assertThat(aURepo.findByUsername("Test0")).isNull();
	}

	@Test
	public void findUserTest() {
		Long id = aURepo.save(aUL.get(0)).getId();
		assertThat(aURepo.findById(id).isPresent());
	}

	@Test
	public void findAllUsers() {
		aUL.forEach(aURepo::save);
		List<AppUser> l = new ArrayList<>();
		aURepo.findAll().forEach(l::add);
		assertEquals(l.size(), 4);
	}

}

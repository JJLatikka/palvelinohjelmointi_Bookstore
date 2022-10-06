package bookstore.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import bookstore.domain.entities.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

	AppUser findByUsername(String userName);

}

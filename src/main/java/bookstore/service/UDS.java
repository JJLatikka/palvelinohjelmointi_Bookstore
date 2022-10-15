package bookstore.service;

/**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookstore.domain.entities.AppUser;
import bookstore.domain.repositories.AppUserRepository;

@Service
public class UDS implements UserDetailsService {

	private final AppUserRepository userRepository;

	@Autowired
	public UDS(AppUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String uN) throws UsernameNotFoundException {
		AppUser aU = userRepository.findByUsername(uN);
		UserDetails d = new org.springframework.security.core.userdetails.User(uN, aU.getPassHash(),
				AuthorityUtils.createAuthorityList(aU.getRole()));
		return d;
	}

}
/**/
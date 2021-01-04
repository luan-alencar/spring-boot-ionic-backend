package david.augusto.luan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import david.augusto.luan.domain.Cliente;
import david.augusto.luan.repositories.ClienteRepository;
import david.augusto.luan.security.UserSS;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = clienteRepository.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}
}

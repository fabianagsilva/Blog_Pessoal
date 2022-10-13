package com.gerenation.blogpessoal.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.gerenation.blogpessoal.model.Usuario;
import com.gerenation.blogpessoal.repository.UsuarioRepository;

/**
 * @author Fabiana
 * @version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " não encontrado."));
		return usuario.map(UserDetailsImpl::new).get();
	}
	
}
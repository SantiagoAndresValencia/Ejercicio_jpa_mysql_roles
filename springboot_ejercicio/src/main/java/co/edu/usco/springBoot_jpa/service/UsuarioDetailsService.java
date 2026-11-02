package co.edu.usco.springBoot_jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.usco.springBoot_jpa.model.Rol;
import co.edu.usco.springBoot_jpa.model.Usuario;
import co.edu.usco.springBoot_jpa.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getName()));
		}

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, roles);
	}

}

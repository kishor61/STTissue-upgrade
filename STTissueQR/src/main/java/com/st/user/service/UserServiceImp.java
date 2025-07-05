package com.st.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.user.dao.UserDao;

@Service
public class UserServiceImp implements UserDetailsService ,UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;

	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

	    com.st.user.model.User user = userDao.getUser(username);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found: " + username);
	    }

	    // Prefix the role with "ROLE_"
	    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
	    authorities.add(authority);

	    return new User(user.getUsername(), "{noop}" + user.getPassword(), user.isEnabled(), accountNonExpired,
	            credentialsNonExpired, accountNonLocked, authorities);
	}

	@Transactional
	@Override
	public com.st.user.model.User getUser(String username) {
		return userDao.getUser(username);
	}

	

}
package com.sample.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.app.model.UserAuthorizations;
import com.sample.app.model.User;
import com.sample.app.model.UserPrincipal;
import com.sample.app.repository.UserAuthorizationRepository;
import com.sample.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAuthorizationRepository authGroupRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not exist");
		}
		
		List<UserAuthorizations> authGroups = authGroupRepository.findByUserName(user.getUserName());
		
		
		return new UserPrincipal(user, authGroups);
	}

}

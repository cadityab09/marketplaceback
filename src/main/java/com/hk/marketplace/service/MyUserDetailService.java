package com.hk.marketplace.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hk.marketplace.entity.UserPrincipal;
import com.hk.marketplace.entity.Users;
import com.hk.marketplace.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepo.findByUsername(username);
		System.out.println("Aditya Chavan");
		
		if(user == null) {
			System.out.println("User not Found");
			throw new UsernameNotFoundException("User not found.");
		}
		if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("password") // {noop} is for plaintext password. Consider using BCrypt
                    .roles("USER")
                    .build();
        }
        
		return new UserPrincipal(user);
	}
}

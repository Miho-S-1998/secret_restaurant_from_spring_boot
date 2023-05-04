package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;
import com.example.demo.model.SiteUser;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.util.Authority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner{
	private final PasswordEncoder passwordEncoder;
	private final SiteUserRepository userRepository;
	private final CommentRepository repository;
	
	@Override
	public void run(ApplicationArguments args)throws Exception{
		var user=new SiteUser();
		user.setUsername("master");
		user.setPassword(passwordEncoder.encode("password"));
		user.setEmail("secret_sweets@example.com");
		user.setGender(0);
		user.setAdmin(true);
		user.setAuthority(Authority.ADMIN);
		if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
			userRepository.save(user);
		}
		
		var comment=new Comment();
        comment.setContent("流石！マスター!");
		repository.save(comment);
		
		var comment2=new Comment();
		comment2.setContent("美味しそう!");
		repository.save(comment2);
	}
}

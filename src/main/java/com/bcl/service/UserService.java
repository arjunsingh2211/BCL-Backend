package com.bcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.bcl.entity.User;
import com.bcl.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public User addUser(User user) {
		User savedUser= userRepository.save(user);
		
		sendEmailToUser(user);
		sendEmailToAdmin(user);
		
		return savedUser;
	}
	
	private void sendEmailToUser(User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("Query Received");
		message.setText("Query received. Our technical team will reach out to you soon.");
		javaMailSender.send(message);
	}
	
	private void sendEmailToAdmin(User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("arjunsrajput2204@gmail.com");
		message.setSubject("New User Query");
		message.setText("Query received from user - Name: " + user.getName() + 
						", Email: " + user.getEmail() +
						", Query: " + user.getMessage());
		javaMailSender.send(message);
	}
	
	
	
	public List<User> getUser(){
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}
}

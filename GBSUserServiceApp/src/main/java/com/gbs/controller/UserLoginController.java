package com.gbs.controller;

import java.util.List;

//import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.*;
import com.gbs.repository.*;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	@Autowired
	UserLoginRepository userLoginRepository;

	@GetMapping("/userLoginResponse")
	public UserLoginResponse getAllUserResponse() {
		List<UserLogin> userList = userLoginRepository.findAll();
		UserLoginResponse userResponse = new UserLoginResponse();
		userResponse.setUserLogin(userList);
		return userResponse;
	}
	@PutMapping("/update/{id}")
	public UserLogin updateAccount(@PathVariable(value="id") String userAccNumber,
			@RequestBody UserLogin userFromBrowser) {

		UserLogin existingAccount = userLoginRepository.findById(userAccNumber).get();
		existingAccount.setTotalBalance(userFromBrowser.getTotalBalance());
		UserLogin updateAccount = userLoginRepository.save(existingAccount);
		return updateAccount;
	}
}
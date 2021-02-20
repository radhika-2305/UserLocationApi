
package com.userLocation.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userLocation.api.model.UserDetails;
import com.userLocation.api.model.User;
import com.userLocation.api.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	UserDetails nameAndCount;

	
	@Override
	public void addUserPostCodeList(List<User> users) {
		users.stream().forEach((u) -> {
			repo.save(u);
		});
	}
	
	@Override
	public UserDetails getNamesBetween(String postCodeFrom, String postCodeTo) {
		List<String> names = repo.getNamesBetween(postCodeFrom, postCodeTo); 
		List<String> sortedNameList = names.stream().sorted().collect(Collectors.toList());
		int totalCharactersCount = sortedNameList.stream().mapToInt(String::length).sum();
		nameAndCount.setSortedNames(sortedNameList);
		nameAndCount.setTotalCharactersInNames(totalCharactersCount);
		return nameAndCount;
	}
	

}

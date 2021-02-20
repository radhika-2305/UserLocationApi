
package com.userLocation.api.service;

import java.util.List;

import com.userLocation.api.model.UserDetails;
import com.userLocation.api.model.User;

public interface UserService {

	void addUserPostCodeList(List<User> record);

	UserDetails getNamesBetween(String postCodeFrom, String postCodeTo);
	
}

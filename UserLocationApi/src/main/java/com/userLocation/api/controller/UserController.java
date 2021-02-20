
package com.userLocation.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userLocation.api.model.User;
import com.userLocation.api.model.UserDetails;
import com.userLocation.api.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService recordService;

	@GetMapping("/users/getNamesBetween/{postCodeFrom}/{postCodeTo}")
	public ResponseEntity<UserDetails> getNamesBetween(@PathVariable String postCodeFrom,@PathVariable String postCodeTo) {
		return ResponseEntity.ok().body(recordService.getNamesBetween(postCodeFrom, postCodeTo));
	}
	
	
	@RequestMapping( value="/users/addUserPostCodeList", method=RequestMethod.POST, consumes="application/json" )
	public HttpStatus addUserPostCodeList(@RequestBody List<User> records) {
		 recordService.addUserPostCodeList(records);
		 return HttpStatus.OK;
	}

}

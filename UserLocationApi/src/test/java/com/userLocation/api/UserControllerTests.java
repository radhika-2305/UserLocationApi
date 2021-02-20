package com.userLocation.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.userLocation.api.controller.UserController;
import com.userLocation.api.model.User;
import com.userLocation.api.model.UserDetails;
import com.userLocation.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserControllerTests {

	@Autowired
	private UserController controller;
	
	@MockBean
	private UserService service;

	public List<User> dataForPost(){
		 User r1 = new  User(1, "CodeTest", "6060");
		 User r2 = new  User(1, "AbcTest", "6010");
		 User r3 = new  User(1, "BTest", "6000");
		 User r4 = new  User(1, "Test", "6018");
		 Stream<User> anStream = Stream.of(r1,r2,r3,r4);
		 return anStream.collect(Collectors.toList());
	}
	
	

	
	@Test
	 void testForCreateRecords() {
		doNothing().when(service).addUserPostCodeList(dataForPost());
		HttpStatus status = controller.addUserPostCodeList(dataForPost());
		assertEquals(status, HttpStatus.OK);
	}
	
	@Test
	 void testForGetNames() throws Exception {
		
		String postCodeFrom = "6000";
		String postCodeTo = "6015";
		
		Stream<String> anStream = Stream.of("AbcTest","BTest");
		List<String> expectedNames =  anStream.collect(Collectors.toList());
		
		int count = 12;
		
		UserDetails mock = new UserDetails(expectedNames, count);

		Mockito.when(service.getNamesBetween(Mockito.anyString(),Mockito.anyString())).thenReturn(mock);
		
	    ResponseEntity<UserDetails> result = controller.getNamesBetween(postCodeFrom, postCodeTo);

		assertEquals(mock.getSortedNames().size(), result.getBody().getSortedNames().size());
		assertEquals(mock.getTotalCharactersInNames(), result.getBody().getTotalCharactersInNames());
	}
	
}

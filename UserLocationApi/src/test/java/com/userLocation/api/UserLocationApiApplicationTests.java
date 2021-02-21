package com.userLocation.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLocation.api.model.User;
import com.userLocation.api.model.UserDetails;
import com.userLocation.api.repository.UserRepository;
import com.userLocation.api.service.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest
public class UserLocationApiApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private UserService recordService;
	
	@MockBean
	private UserRepository repo;

	List<User> input;
	
	
	public List<User> dataForPost(){
		 User r1 = new  User(1, "CodeTest", "6060");
		 User r2 = new  User(1, "AbcTest", "6010");
		 User r3 = new  User(1, "BTest", "6000");
		 User r4 = new  User(1, "Test", "6018");
		 Stream<User> anStream = Stream.of(r1,r2,r3,r4);
		 return anStream.collect(Collectors.toList());
	}
	
	@Test
	 public void testForCallingAddUserPostCodeListApi() throws Exception {
		
		String jsonInput = new ObjectMapper().writeValueAsString(dataForPost());
		doNothing().when(recordService).addUserPostCodeList(dataForPost());
		this.mockMvc.perform(MockMvcRequestBuilders.post("/users/addUserPostCodeList")
				            .content(jsonInput)
				             .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
		
	}
	
	
	@Test
	 public void testForGettingSortedNamesAndCharactersCountApi() throws Exception {
		
		String postCodeFrom = "6000";
		String postCodeTo = "6015";
		
		List<String> expectedNames = new ArrayList<>();
		expectedNames.add("AbcTest");
		expectedNames.add("BTest");
		
		int count = 12;
		
		UserDetails mock = new UserDetails(expectedNames,count);
			
		Mockito.when(
				recordService.getNamesBetween(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mock);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users/getNamesBetween/"+postCodeFrom+"/"+postCodeTo);
		
		MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
		
		ObjectMapper mapper = new ObjectMapper();
		UserDetails expected = mapper.readValue(result.getResponse().getContentAsString(), UserDetails.class);
		assertEquals(mock.getSortedNames().size(), expected.getSortedNames().size());
		assertEquals(mock.getTotalCharactersInNames(), expected.getTotalCharactersInNames());

	}
	

}

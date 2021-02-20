package com.userLocation.api.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
	
	
	private List<String> sortedNames;
	private int totalCharactersInNames;
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetails(List<String> sortedNames,int totalCharactersInNames) {
		this.sortedNames = sortedNames;
		this.totalCharactersInNames =  totalCharactersInNames;
	}
	
	public List<String> getSortedNames() {
		return sortedNames;
	}
	public void setSortedNames(List<String> sortedNames) {
		this.sortedNames = sortedNames;
	}
	public int getTotalCharactersInNames() {
		return totalCharactersInNames;
	}
	public void setTotalCharactersInNames(int totalCharactersInNames) {
		this.totalCharactersInNames = totalCharactersInNames;
	}
	
	

}

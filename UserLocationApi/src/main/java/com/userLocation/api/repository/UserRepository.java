
package com.userLocation.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.userLocation.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select name from records r where r.postcode between ?1 and ?2")
	List<String> getNamesBetween(String postCodeFrom, String postCodeTo);
}

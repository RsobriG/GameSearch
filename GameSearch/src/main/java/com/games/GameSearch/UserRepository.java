package com.games.GameSearch;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

	@Query("Select u from User u where u.nickname = ?1")
	public User findUserByNickname(String nickname);
	
}

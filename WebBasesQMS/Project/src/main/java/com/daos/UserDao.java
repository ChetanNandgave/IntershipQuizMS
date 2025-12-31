package com.daos;

import com.pojos.User;

public interface UserDao extends AutoCloseable {
	User findByEmail(String email) throws Exception;
	int save(User u) throws Exception;
	
	
	

}

package com.company.cxl.service;

import java.util.List;

import com.company.cxl.model.User;

public interface UserService {
	User selectUserByID(long id);

	User selectUserByName(String name);
	
	List<User> selectUsers();

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(long id);
	
	void deleteUsers();

	public boolean isUserExist(User user);
}

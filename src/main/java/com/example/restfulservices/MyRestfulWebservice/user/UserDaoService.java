package com.example.restfulservices.MyRestfulWebservice.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 4;
	
	static {
		User user1 = new User(1, "Kapil", "04-01-1989");
		users.add(user1);
		User user2 = new User(2, "Alka", "14-09-1991");
		users.add(user2);
		User user3 = new User(3, "Takshii", "10-01-2018");
		users.add(user3);
		User user4 = new User(4, "Srishti", "16-10-2006");
		users.add(user4);
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findUser(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

}

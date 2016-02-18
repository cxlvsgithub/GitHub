package com.company.cxl;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.company.cxl.model.User;

public class RestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/RestDemo";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void getUsers() {
		System.out.println("Testing getUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/",
				List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ", Name=" + map.get("name") + ", Age="
						+ map.get("age") + ", Salary=" + map.get("salary"));
				;
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	/* GET */
	private static void getUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", User.class);
		System.out.println(user);
	}

	/* POST */
	/**
	* 
	*/
	private static void insertUser() {
		System.out.println("Testing insertUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(0, "壮志凌云", 51, 134);
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/* PUT */
	private static void updateUser() {
		System.out.println("Testing updateUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1, "Tomy", 33, 70000);
		restTemplate.put(REST_SERVICE_URI + "/user/1", user);
		System.out.println(user);
	}

	/* DELETE */
	private static void deleteUser() {
		System.out.println("Testing deleteUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/3");
	}

	/* DELETE */
	private static void insertUsers() {
		System.out.println("Testing deleteUsers API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/");
	}

	public static void main(String args[]) {
		getUsers();
		getUser();
		insertUser();
		getUsers();
		updateUser();
		getUsers();
		deleteUser();
		getUsers();
		insertUsers();
		getUsers();
	}
}

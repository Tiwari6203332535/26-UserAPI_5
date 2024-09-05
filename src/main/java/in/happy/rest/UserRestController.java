package in.happy.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.happy.binding.User;

@RestController
public class UserRestController {
	private Map<Integer, User> dataMap = new HashMap<>();

	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		// public ResponseEntity<String> addUser(String user) {
		// Writr logic to convert JSON to java--but our Api will get tightly coupled
		// if we get xml data our api will not work
		System.out.println(user);
		dataMap.put(user.getId(), user);
		return new ResponseEntity<String>("user saved", HttpStatus.CREATED);
	}

	// localhost:8080/user?userid=101
	@GetMapping("/user")
	public User getUse(@RequestParam("userid") Integer userId) {
		User user = dataMap.get(userId);
		return user;
	}

	// multiple querry parameter=Get method
	// localhost:8080/user1?userid=101&username=raja

	@GetMapping("/user1")
	public User getUseData(@RequestParam("userid") Integer userId, @RequestParam("username") String name) {
		User user = dataMap.get(userId);
		return user;
	}

	// pathparameter
	// urlpattern= localhost:8080/user/101/data
	// multiple pathaparameter=localhost:8080/user/101/data{name}
	@GetMapping("/user/{id}/data")
	public User getUseByPath(@PathVariable("id") Integer userId) {
		User user = dataMap.get(userId);
		return user;
	}
}
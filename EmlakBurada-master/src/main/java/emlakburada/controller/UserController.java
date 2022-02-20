package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserResponse>> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserResponse> getUserByUserId(@PathVariable(required = false) Long userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
	}
}

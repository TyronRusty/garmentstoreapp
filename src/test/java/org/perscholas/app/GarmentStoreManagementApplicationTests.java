package org.perscholas.app;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.perscholas.app.dao.MyUserRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.MyUser;
import org.perscholas.app.service.ImageService;
import org.perscholas.app.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GarmentStoreManagementApplicationTests {
	@Autowired
	ImageService imageService;
	@Autowired
	MyUserService myUserService;
	@Autowired
	MyUserRepoI myUserRepoI;

//static List<MyUser> expected(){
//
//	MyUser myUser1 = new MyUser(41,"mike","seven","mikeseven@gmail.com","123 rue old","Shibuya","password");
//	MyUser myUser2 = new MyUser(42,"ken","monk","kennym@gmail.com","153 road nod","lorain","password");
//	List<MyUser> expected = new ArrayList<>();
//	expected.add(myUser1);
//	expected.add(myUser2);
//	return expected ;
//}

	//	@Test
//	void contextLoads() {
//	}

	public void testListAll() {
		// this creates users
		MyUser user3 = new MyUser(47, "ron", "loth", "lorthron@example.com", "445-9876", "password", "700 south St", "ozark", "OZ", 45646);
		MyUser user4 =  new MyUser(49, "seth", "Smith", "sethsm@example.com", "555-9876", "password", "789 Oak St", "Smalltown", "IL", 45678);

		// Saving the users
		myUserRepoI.save(user3);
		myUserRepoI.save(user4);

		// finding the users , making sure they exist
		List<MyUser> userList = myUserRepoI.findAll();
		assert (userList.contains(user3));
		assert (userList.contains(user4));
	}
	@Test
	public void testSave() {
		// Create a new user and save it
		MyUser newUser = new MyUser(60, "tim", "stone", "stoned@example.com", "895-1234", "password", "123 stoned rd", "Anytown", "CA", 12045);
		MyUser savedUser = myUserService.save(newUser);

		// Check if the saved user has the correct fields
		assert(savedUser.getFirstName().equals(newUser.getFirstName()));
		assert(savedUser.getLastName().equals(newUser.getLastName()));
		assert(savedUser.getEmail().equals(newUser.getEmail()));
		assert(savedUser.getPhone().equals(newUser.getPhone()));
		assert(savedUser.getPassword().equals(newUser.getPassword()));
		assert(savedUser.getAddress().equals(newUser.getAddress()));
		assert(savedUser.getCity().equals(newUser.getCity()));
		assert(savedUser.getState().equals(newUser.getState()));
		assert(savedUser.getZipCode() == newUser.getZipCode());

		// Update the user and save it again
		savedUser.setFirstName("Jane");
		savedUser.setLastName("Doe");
		savedUser.setCity("Otherville");
		MyUser updatedUser = myUserService.save(savedUser);

		// Check if the updated user has the correct fields
		assert(updatedUser.getFirstName().equals("Jane"));
		assert(updatedUser.getLastName().equals("Doe"));
		assert(updatedUser.getCity().equals("Otherville"));

	}


}

# springboot-data-jpa-rest

#### Prerequisite
* Create Spring Boot Project 
* Configure DataSource and JPA


#### Task 1: Create DAO for User
* Register User
* Get all users
* Get user by id
* Delete user by id

```
public interface UserDAO extends JpaRepository<User,Integer>{

	User save(User user);

	@Query("select u from User u")
	List<User> list();
	
	@Query("select u from User u where u.id = :userId")
	User findOne(@Param("userId") Integer id);

	@Modifying
	@Query("delete from User where id = :userId")
	void delete(@Param("userId") Integer id);

}
```

#### Task 2: Create RestController for User API
* Register User
* Get all users
* Get user by id
* Delete user by id
```

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.bankingappspringdata.model.User;
import com.naresh.bankingappspringdata.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping()
	public @ResponseBody void register(@RequestBody User user) {
		System.out.println("UserController->save");
		userService.registerUser(user);
	}

	@GetMapping()
	public List<User> list() {
		List<User> list = userService.list();
		return list;
	}

	@GetMapping("/{id}")
	public User findOne(@PathVariable("id") Integer id) {
		User user = userService.findOne(id);
		return user;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);

	}

}

```

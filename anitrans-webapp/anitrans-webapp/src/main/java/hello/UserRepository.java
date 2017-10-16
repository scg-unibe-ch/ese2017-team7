package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// The repository for the user object. Methods to search the database will go in here.

public interface UserRepository extends CrudRepository<User, Long> {
	
	hello.User findById(Integer id);

}

package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// The repository for the user object. Methods to search the database will go in here.

/*
 * Repository for user. This is where methods to search/sort the database go.
 * See https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation, 4.3.2. Query creation.
 */
public interface NewUserRepository extends CrudRepository<NewUser, Long> {
	
	hello.User findById(Integer id);
	hello.User findByEmail(String email);

}

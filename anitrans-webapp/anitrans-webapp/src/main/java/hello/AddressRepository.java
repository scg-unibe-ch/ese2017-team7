package hello;

import org.springframework.data.repository.CrudRepository;

import hello.AniOrder;

// This will be AUTO IMPLEMENTED by Spring into a Bean called orderRepository
// CRUD refers Create, Read, Update, Delete
// Repository for Addresses. Methods to search the database will go in here.

/*
 * This models the Address Repository.
 * Methods to search the database (including sorting) go here.
 * See https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation, 4.3.2. Query creation.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
	
	hello.Address findById(Integer id);
	
}

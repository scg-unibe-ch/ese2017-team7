package hello;

import org.springframework.data.repository.CrudRepository;
import java.util.*; 

import hello.AniOrder;

// This will be AUTO IMPLEMENTED by Spring into a Bean called orderRepository
// CRUD refers Create, Read, Update, Delete
// Repository for AniOrders. Methods to search the database will go in here.

/*
 * Repository for AniOrders. This is where methods to search (and sort) the AniOrder table go.
 * See https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation, 4.3.2. Query creation.
 */
public interface OrderRepository extends CrudRepository<AniOrder, Long> {
	
	hello.AniOrder findById(Integer id); //returns a single order, because the ID is unique
	List<hello.AniOrder> findByDriver(String driver); //returns a list, because a driver may drive multiple orders.
	
}

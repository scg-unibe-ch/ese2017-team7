package hello;

import org.springframework.data.repository.CrudRepository;

import hello.AniOrder;

// This will be AUTO IMPLEMENTED by Spring into a Bean called orderRepository
// CRUD refers Create, Read, Update, Delete
// Repository for AniOrders. Methods to search the database will go in here.

public interface AddressRepository extends CrudRepository<Address, Long> {
	
	hello.Address findById(Integer id);
	
}

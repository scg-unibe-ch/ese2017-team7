package hello;

import org.springframework.data.repository.CrudRepository;

import hello.AniOrder;

// This will be AUTO IMPLEMENTED by Spring into a Bean called orderRepository
// CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<AniOrder, Long> {
	
	hello.AniOrder findById(Integer id);
	
}

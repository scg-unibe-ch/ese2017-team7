package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// The repository for the user object. Methods to search the database will go in here.

/*
 * Repository for NewOrders. These are only used to pass information from the form-fields to the AniOrder table.
 */
public interface EditedOrderRepository extends CrudRepository<EditedOrder, Long> {
	


}

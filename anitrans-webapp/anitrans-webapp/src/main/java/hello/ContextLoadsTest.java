package hello;

import static org.junit.Assert.*;

import hello.*;
import hello.controllers.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
=======
>>>>>>> parent of 7fe2228... added .jar
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;



/*
 * Tests methods which are related to an order and do not access the website or database.
 * The database and website aren't accessible in test cases.
 */
<<<<<<< HEAD
@RunWith(SpringJUnit4ClassRunner.class)
=======
@RunWith(SpringRunner.class)
>>>>>>> parent of 7fe2228... added .jar
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContextLoadsTest {	
	@LocalServerPort
	private int port;
	
	@Autowired
	private OrdersController ordersController;
	@Autowired
	private AddOrderController addOrderController;
	@Autowired
	private ChangeStatusController changeStatusController;
	@Autowired
	private EditOrderController editOrderController;
	@Autowired
	private OrderDetailsController orderDetailsController;
	@Autowired 
	private ToursController toursController;
	@Autowired 
	private DriversController driversController;
	@Autowired 
	private ErrorHandlingController errorHandlingController;
	@Autowired 
	private HomeController homeController;
	@Autowired 
	private LoginController loginController;
	@Autowired 
	private NewVehicleController newVehicleController;
	@Autowired 
	private RegisterController registerController;
	@Autowired 
	private VehicleController vehicleController;

	
	//Tests if application context loads and that the controllers aren't null
	@Test
	public void contextLoads() throws Exception {
		assertThat(ordersController).isNotNull();
		assertThat(addOrderController).isNotNull();
		assertThat(changeStatusController).isNotNull();
		assertThat(editOrderController).isNotNull();
		assertThat(orderDetailsController).isNotNull();
		assertThat(toursController).isNotNull();
		assertThat(driversController).isNotNull();
		assertThat(errorHandlingController).isNotNull();
		assertThat(homeController).isNotNull();
		assertThat(loginController).isNotNull();
		assertThat(newVehicleController).isNotNull();
		assertThat(registerController).isNotNull();
		assertThat(vehicleController).isNotNull();
	}


}



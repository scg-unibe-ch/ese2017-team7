package hello.tests;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import hello.*;
import hello.controllers.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.containsString;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/*
 * Tests all methods related to orders (conversion from newOrder to aniOrder and back, sorting,
 * and whether the orders page can be accessed by the right people or not.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class OrderTestMock {	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	

	
	//Tests the conversion from NewOrder to AniOrder and back
	@Test
	public void conversion() {
		NewOrder order = new NewOrder();
		order.setOrderId(1);
		order.setFromName("Max Muster");
		order.setFromStreet("Strasse 8");
		order.setFromTown("Stadt");
		order.setFromPlz(9999);
		order.setToName("John Doe");
		order.setToStreet("Street");
		order.setToTown("Town");
		order.setToPlz(0000);
		order.setUntil(new Date());
		order.setTimeframe("10:00 - 11:00");
		order.setNumberOfAnimals(9);
		order.setTypeOfAnimal("Dogs");
		order.setTimeEstimation(3);
		order.setStartTime(new Date());
		order.setDriver("1 - Lord MacDonald");
		order.setVehicle("Tiny Truck");
		order.setOrderStatus("undelivered");
		order.setStatusMessage("exploded");
		
		hello.Address fromAddress = new hello.Address(order.getFromName(), order.getFromStreet(), order.getFromTown(), order.getFromPlz());
		hello.Address toAddress = new hello.Address(order.getToName(), order.getToStreet(), order.getToTown(), order.getToPlz());
		
		AniOrder aniOrder = new AniOrder(order, fromAddress, toAddress);
		
		NewOrder newOrder = new NewOrder(aniOrder, fromAddress, toAddress);
		
		assertTrue(order.getOrderId() == newOrder.getOrderId());
		assertTrue(order.getFromName().equals(newOrder.getFromName()));
		assertTrue(order.getFromStreet().equals(newOrder.getFromStreet()));
		assertTrue(order.getFromTown().equals(newOrder.getFromTown()));
		assertTrue(order.getFromPlz() == newOrder.getFromPlz());
		assertTrue(order.getToName().equals(newOrder.getToName()));
		assertTrue(order.getToStreet().equals(newOrder.getToStreet()));
		assertTrue(order.getToTown().equals(newOrder.getToTown()));
		assertTrue(order.getToPlz() == newOrder.getToPlz());
		assertTrue(order.getUntil().equals(newOrder.getUntil()));
		assertTrue(order.getTimeframe().equals(newOrder.getTimeframe()));
		assertTrue(order.getNumberOfAnimals().equals(newOrder.getNumberOfAnimals()));
		assertTrue(order.getTypeOfAnimal().equals(newOrder.getTypeOfAnimal()));
		assertTrue(order.getTimeEstimation() == newOrder.getTimeEstimation());
		assertTrue(order.getStartTime().equals(newOrder.getStartTime()));
		assertTrue(order.getDriver().equals(newOrder.getDriver()));
		assertTrue(order.getVehicle().equals(newOrder.getVehicle()));
		assertTrue(order.getOrderStatus().equals(newOrder.getOrderStatus()));
		assertTrue(order.getStatusMessage().equals(newOrder.getStatusMessage()));
		
	}
	
	
	//Tests the sorting of orders
	@Test
	public void sorting() {
		ArrayList<hello.AniOrder> allOrders = new ArrayList<>();
		SortingService sortingService = new SortingService();
		
		NewOrder orderOne = new NewOrder();
		orderOne.setOrderId(1);
		orderOne.setFromName("Max Muster");
		orderOne.setFromStreet("Strasse 8");
		orderOne.setFromTown("Stadt");
		orderOne.setFromPlz(9999);
		orderOne.setToName("John Doe");
		orderOne.setToStreet("Street");
		orderOne.setToTown("Town");
		orderOne.setToPlz(0000);
		orderOne.setUntil(new Date());
		orderOne.setTimeframe("10:00 - 11:00");
		orderOne.setNumberOfAnimals(9);
		orderOne.setTypeOfAnimal("Dogs");
		orderOne.setTimeEstimation(3);
		orderOne.setStartTime(new Date());
		orderOne.setDriver("1 - Lord MacDonald");
		orderOne.setVehicle("Tiny Truck");
		orderOne.setOrderStatus("undelivered");
		orderOne.setStatusMessage("exploded");
		
		hello.Address fromAddress = new hello.Address(orderOne.getFromName(), orderOne.getFromStreet(), orderOne.getFromTown(), orderOne.getFromPlz());
		hello.Address toAddress = new hello.Address(orderOne.getToName(), orderOne.getToStreet(), orderOne.getToTown(), orderOne.getToPlz());
		
		AniOrder aniOrderOne = new AniOrder(orderOne, fromAddress, toAddress);
		
		NewOrder orderTwo = new NewOrder();
		orderTwo.setOrderId(2);
		orderTwo.setFromName("Max Muster");
		orderTwo.setFromStreet("Strasse 8");
		orderTwo.setFromTown("Stadt");
		orderTwo.setFromPlz(9999);
		orderTwo.setToName("John Doe");
		orderTwo.setToStreet("Street");
		orderTwo.setToTown("Town");
		orderTwo.setToPlz(0000);
		orderTwo.setUntil(new Date());
		orderTwo.setTimeframe("10:00 - 11:00");
		orderTwo.setNumberOfAnimals(9);
		orderTwo.setTypeOfAnimal("Dogs");
		orderTwo.setTimeEstimation(3);
		orderTwo.setStartTime(new Date());
		orderTwo.setDriver("1 - Lord MacDonald");
		orderTwo.setVehicle("Tiny Truck");
		orderTwo.setOrderStatus("delivered");
		orderTwo.setStatusMessage("");
		
		fromAddress = new hello.Address(orderTwo.getFromName(), orderTwo.getFromStreet(), orderTwo.getFromTown(), orderTwo.getFromPlz());
		toAddress = new hello.Address(orderTwo.getToName(), orderTwo.getToStreet(), orderTwo.getToTown(), orderTwo.getToPlz());
		
		AniOrder aniOrderTwo = new AniOrder(orderTwo, fromAddress, toAddress);
		
		NewOrder orderThree = new NewOrder();
		orderThree.setOrderId(4);
		orderThree.setFromName("Max Muster");
		orderThree.setFromStreet("Strasse 8");
		orderThree.setFromTown("Stadt");
		orderThree.setFromPlz(9999);
		orderThree.setToName("John Doe");
		orderThree.setToStreet("Street");
		orderThree.setToTown("Town");
		orderThree.setToPlz(0000);
		orderThree.setUntil(new Date());
		orderThree.setTimeframe("10:00 - 11:00");
		orderThree.setNumberOfAnimals(9);
		orderThree.setTypeOfAnimal("Dogs");
		orderThree.setTimeEstimation(3);
		orderThree.setStartTime(new Date());
		orderThree.setDriver("1 - Lord MacDonald");
		orderThree.setVehicle("Tiny Truck");
		orderThree.setOrderStatus("delivered");
		orderThree.setStatusMessage("ok");
		
		fromAddress = new hello.Address(orderThree.getFromName(), orderThree.getFromStreet(), orderThree.getFromTown(), orderThree.getFromPlz());
		toAddress = new hello.Address(orderThree.getToName(), orderThree.getToStreet(), orderThree.getToTown(), orderThree.getToPlz());
		
		AniOrder aniOrderThree = new AniOrder(orderThree, fromAddress, toAddress);
		
		
		NewOrder orderFour = new NewOrder();
		orderFour.setOrderId(3);
		orderFour.setFromName("Max Muster");
		orderFour.setFromStreet("Strasse 8");
		orderFour.setFromTown("Stadt");
		orderFour.setFromPlz(9999);
		orderFour.setToName("John Doe");
		orderFour.setToStreet("Street");
		orderFour.setToTown("Town");
		orderFour.setToPlz(0000);
		orderFour.setUntil(new Date());
		orderFour.setTimeframe("10:00 - 11:00");
		orderFour.setNumberOfAnimals(9);
		orderFour.setTypeOfAnimal("Dogs");
		orderFour.setTimeEstimation(3);
		orderFour.setStartTime(new Date());
		orderFour.setDriver("1 - Lord MacDonald");
		orderFour.setVehicle("Tiny Truck");
		orderFour.setOrderStatus("undelivered");
		orderFour.setStatusMessage("exploded");
		
		fromAddress = new hello.Address(orderFour.getFromName(), orderFour.getFromStreet(), orderFour.getFromTown(), orderFour.getFromPlz());
		toAddress = new hello.Address(orderFour.getToName(), orderFour.getToStreet(), orderFour.getToTown(), orderFour.getToPlz());
		
		AniOrder aniOrderFour = new AniOrder(orderFour, fromAddress, toAddress);
		
		
		
		allOrders.add(aniOrderOne);
		allOrders.add(aniOrderTwo);
		allOrders.add(aniOrderThree);
		allOrders.add(aniOrderFour);
		
		ArrayList<AniOrder> successful = sortingService.getSuccessful(allOrders);
		ArrayList<AniOrder> unsuccessful = sortingService.getUnsuccessful(allOrders);
		
		ArrayList<AniOrder> shouldBeSuccessful = new ArrayList<>();
		shouldBeSuccessful.add(aniOrderThree);
		shouldBeSuccessful.add(aniOrderTwo);
		
		ArrayList<AniOrder> shouldBeUnsuccessful = new ArrayList<>();
		shouldBeUnsuccessful.add(aniOrderFour);
		shouldBeUnsuccessful.add(aniOrderOne);
		
		assertTrue(successful.get(1).equals(shouldBeSuccessful.get(1)));
		assertTrue(successful.get(1).equals(shouldBeSuccessful.get(1)));
		assertTrue(successful.get(0).equals(shouldBeSuccessful.get(0)));
		assertTrue(successful.get(0).equals(shouldBeSuccessful.get(0)));
		
		assertTrue(unsuccessful.get(1).equals(shouldBeUnsuccessful.get(1)));
		assertTrue(unsuccessful.get(1).equals(shouldBeUnsuccessful.get(1)));
		assertTrue(unsuccessful.get(0).equals(shouldBeUnsuccessful.get(0)));
		assertTrue(unsuccessful.get(0).equals(shouldBeUnsuccessful.get(0)));
		
	}

	//Tests that the orders.html page is not accessible without logging in first
	@Test
	public void ordersShouldBeLocked() throws Exception {
		this.mockMvc.perform(get("/orders")).andDo(print()).andExpect(status().isFound());
	}
	
	//Tests that the add-order.html page is not accessible without logging in first
	@Test
	public void addOrdersShouldBeLocked() throws Exception {
		this.mockMvc.perform(get("/add-order")).andDo(print()).andExpect(status().isFound());
	}
	

	//Tests that orders.html has text
	@Test
	@WithMockUser(roles={"USER","ADMIN"})
	public void ordersHasText() throws Exception {
		this.mockMvc.perform(get("/orders")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Undelivered Orders")));
    }
	
	@Test
	@WithMockUser(roles={"USER"})
	public void onlyAdminCanSeeOrders() throws Exception {
		this.mockMvc.perform(post("/orders")).andDo(print())
        .andExpect(status().isForbidden());
    }
	
		//Tests that orders are displayed
		@Test
		@WithMockUser(roles={"USER","ADMIN"})
		public void ordersHasOrders() throws Exception {
			this.mockMvc.perform(get("/orders")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("Casterly Rock")));
	    }

}



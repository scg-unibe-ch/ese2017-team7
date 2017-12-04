package hello.tests;

import static org.junit.Assert.*;
import hello.*;
import hello.controllers.*;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.junit.Test;

/*
 * Tests methods which are related to an order and do not access the website or database.
 */
public class OrdersTest {
	@Autowired
	private hello.OrderRepository orderRepository;

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
	
}


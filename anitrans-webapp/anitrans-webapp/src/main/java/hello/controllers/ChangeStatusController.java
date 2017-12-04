package hello.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeStatusController {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	@Autowired
	private hello.AddressRepository addressRepository;
	@Autowired
	private hello.VehicleRepository vehicleRepository;

	/*
	 * Maps get requests for /change-status. The id of the order to be edited has to be passed through the URL.
	 */
    @GetMapping("/change-status")
    public String statusForm(@RequestParam Integer id, Model model) {
    	hello.AniOrder order;
		if(id != null) {
			order  = orderRepository.findById(id); //finds the correct order using the id passed through the URL.
		} else {
			order = new hello.AniOrder(); //if the order doesn't exists, a new order is created.
		}
		
		hello.EditedOrder EditedOrder = new hello.EditedOrder(order, order.getFromAddr(), order.getToAddr());
		
		model.addAttribute("order", EditedOrder); //passes the order to change-status.html
		model.addAttribute("users", userRepository.findAll()); //passes all the users to change-status.html. this is needed to select the driver.
		model.addAttribute("vehicles", vehicleRepository.findAll()); //find all the vehicles and pass them to add-order.html. This is needed to select the vehicle.
    return "change-status"; //return the template
    }
    
    //Maps post requests for /change-status. 
    @PostMapping("/change-status")
    public String statusSubmit(@Valid @ModelAttribute hello.EditedOrder order, BindingResult bindingResult, Model model) {
    		if (bindingResult.hasErrors()) { //check if the changed order is still valid. If it has errors, send the user back to correct them. Wrong values will be marked.
			model.addAttribute("order", order);
			model.addAttribute("users", userRepository.findAll());
			model.addAttribute("vehicles", vehicleRepository.findAll()); //find all the vehicles and pass them to add-order.html. This is needed to select the vehicle.
			return "change-status"; //return the template
		}
		
    		hello.AniOrder oldOrder = orderRepository.findById(order.getOrderId());
    		
    		//create addresses and aniOrders from the data.
    		hello.Address fromAddress = new hello.Address(order.getFromName(), order.getFromStreet(), order.getFromTown(), order.getFromPlz());
    		hello.Address toAddress = new hello.Address(order.getToName(), order.getToStreet(), order.getToTown(), order.getToPlz());
    		hello.AniOrder aniOrder = new hello.AniOrder(order, fromAddress, toAddress);
    		
    		orderRepository.delete(oldOrder);	
    		addressRepository.delete(oldOrder.getFromAddr()); //delete the old addresses to avoid duplicates
    		addressRepository.delete(oldOrder.getToAddr());
    		
    		addressRepository.save(fromAddress); //save the address to the database.
    		addressRepository.save(toAddress); //save the address to the database.
		orderRepository.save(aniOrder); //save the order to the database.

        return "change-status-success"; //return the template
    }

}
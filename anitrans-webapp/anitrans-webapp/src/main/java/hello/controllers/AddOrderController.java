package hello.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddOrderController {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	@Autowired
	private hello.AddressRepository addressRepository;
	@Autowired
	private hello.NewOrderRepository newOrderRepository;
	
	 //Maps get requests for /add-order. 
    @GetMapping("/add-order")
    public String orderForm(Model model) {
    		model.addAttribute("newOrder", new hello.NewOrder());  //create a new order and pass it to add-order.html
    		model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
        return "add-order"; //returns the template
    }
    
    //Maps post requests for /add-order
    @PostMapping("/add-order")
    public String orderSubmit(@Valid @ModelAttribute hello.NewOrder order, BindingResult bindingResult, Model model) {
    		if (bindingResult.hasErrors()) { //if the new order has errors, send the user back to correct the mistakes. Invalid fields will be marked.
    			model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
            return "add-order"; //returns the template
    		}
    		
    		//create address and order objects from the information provided by the user.
    		hello.Address fromAddress = new hello.Address(order.getFromName(), order.getFromStreet(), order.getFromTown(), order.getFromPlz());
    		hello.Address toAddress = new hello.Address(order.getToName(), order.getToStreet(), order.getToTown(), order.getToPlz());
    		hello.AniOrder aniOrder = new hello.AniOrder(order, fromAddress, toAddress);
    		
    		addressRepository.save(fromAddress); //save the address to the database.
    		addressRepository.save(toAddress); //save the address to the database.
		orderRepository.save(aniOrder); //save the order to the database.
		newOrderRepository.delete(order); //delete the newOrder from the database as it is no longer needed.
		return "add-order-success"; //returns the template
    }
    

}

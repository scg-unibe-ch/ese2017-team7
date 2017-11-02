package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class OrdersController {
	@Autowired
	private hello.OrderRepository orderRepository;

	
	// Maps all requests for  /orders. 
    @RequestMapping("/orders")
    	public String orders(Model model) {
    	    model.addAttribute("orders", orderRepository.findAll()); //Finds all the orders which are to be displayed in orders.html
    	    return "orders"; //returns the template 
    }
    

}
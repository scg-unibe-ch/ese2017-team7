package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.SortingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

import javax.validation.Valid;

@Controller
public class OrdersController {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private SortingService service;
	
	
	// Maps all requests for  /orders. 
    @RequestMapping("/orders")
    	public String orders(Model model) {
    	    
    	    ArrayList<hello.AniOrder> successfulOrders = service.getSuccessful(orderRepository.findAll());
    	    ArrayList<hello.AniOrder> unsuccessfulOrders = service.getUnsuccessful(orderRepository.findAll());
    	    
    	    if(successfulOrders.size() <= 0) {
    	    		model.addAttribute("successfulOrdersError", "There are no delivered orders.");
    	    }
    	    if(unsuccessfulOrders.size() <= 0) {
	    		model.addAttribute("unsuccessfulOrdersError", "There are no undelivered orders.");
	    }
    	    
    	    model.addAttribute("successfulOrders", successfulOrders); //Finds all the orders which are to be displayed in orders.html
    	    model.addAttribute("unsuccessfulOrders", unsuccessfulOrders); //Finds all the orders which are to be displayed in orders.html

    	    return "orders"; //returns the template 
    }

}


//might need more methods, 2 methods one to get completed and one for non-completed 

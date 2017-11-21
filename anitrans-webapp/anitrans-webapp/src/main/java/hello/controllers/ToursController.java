package hello.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.SortingService;

import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.authentication.*;

@Controller
public class ToursController {	
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	
	//returns the username (email) of the user who is currently logged in.
	public String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		} else {
			return "";
		}
	}
	
	// Maps all requests for /tours.
    @RequestMapping("/tours")
    public String index(Model model) {
    		if(!getUserName().equals("")) {
    			hello.User currentUser = userRepository.findByEmail(getUserName()); //gets the user who is currently logged in
    			model.addAttribute("orders", orderRepository.findByDriver(currentUser.getName())); //Finds all the orders to be displayed on tours.html (only the ones which the current user is driving).
    	        return "tours";	//return the template	
    		} else {
    			return "tours"; //return the template
    		}
    		
    }
   
    	
    	@Autowired
    	private SortingService service;
    	
    	
    	// Maps all requests for  /orders. 
        @RequestMapping("/orders")
        	public String orders(Model model) {
        	    
        	    ArrayList<hello.AniOrder> successfulOrders = service.getSuccessful();
        	    ArrayList<hello.AniOrder> unsuccessfulOrders = service.getUnsuccessful();
        	    
        	    model.addAttribute("successfulOrders", successfulOrders); //Finds all the orders which are to be displayed in orders.html
        	    model.addAttribute("unsuccessfulOrders", unsuccessfulOrders); //Finds all the orders which are to be displayed in orders.html

        	    return "orders"; //returns the template 
        }

    }


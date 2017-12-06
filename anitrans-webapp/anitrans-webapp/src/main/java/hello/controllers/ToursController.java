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
	@Autowired
	private SortingService service;
	
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
    			
    			//Finds all the orders to be displayed on tours.html (only the ones which the current user is driving).
    			ArrayList<hello.AniOrder> successfulOrders = service.getSuccessful(orderRepository.findByDriverOrderByUntilAsc(currentUser.getName()));
        	    ArrayList<hello.AniOrder> unsuccessfulOrders = service.getUnsuccessful(orderRepository.findByDriverOrderByUntilDesc(currentUser.getName()));
        	    
        	    if(successfulOrders.size() <= 0) {
    	    			model.addAttribute("successfulOrdersError", "There are no delivered tours.");
        	    }
        	    if(unsuccessfulOrders.size() <= 0) {
        	    		model.addAttribute("unsuccessfulOrdersError", "There are no undelivered tours.");
        	    }

        	    model.addAttribute("successfulOrders", successfulOrders); 
        	    model.addAttribute("unsuccessfulOrders", unsuccessfulOrders);

    			
    	        return "tours";	//return the template	
    		} else {
    			return "tours"; //return the template
    		}
    		
    }

    }


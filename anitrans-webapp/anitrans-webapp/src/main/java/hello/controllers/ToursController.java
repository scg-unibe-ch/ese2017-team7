package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.authentication.*;

@Controller
public class ToursController {	
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	
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
    			hello.User currentUser = userRepository.findByEmail(getUserName());
    			model.addAttribute("orders", orderRepository.findByDriver(currentUser.getName())); //Finds all the orders to be displayed on tours.html
    	        return "tours";		
    		} else {
    			return "tours";
    		}
    		
    }

}
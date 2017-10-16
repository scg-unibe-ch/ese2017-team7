package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToursController {	
	@Autowired
	private hello.OrderRepository orderRepository;
	
	
	// Maps all requests for /tours.
    @RequestMapping("/tours")
    public String index(Model model) {
    		model.addAttribute("orders", orderRepository.findAll()); //Finds all the orders to be displayed on tours.html
        return "tours";
    }

}
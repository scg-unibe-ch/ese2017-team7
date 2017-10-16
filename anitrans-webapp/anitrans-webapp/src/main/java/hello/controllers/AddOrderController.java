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
	
	 //Maps get requests for /add-order. 
    @GetMapping("/add-order")
    public String orderForm(Model model) {
    		model.addAttribute("aniOrder", new hello.AniOrder());  //create a new order and pass it to add-order.html
    		model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
        return "add-order";
    }
    
    //Maps post requests for /add-order
    @PostMapping("/add-order")
    public String orderSubmit(@Valid @ModelAttribute hello.AniOrder aniOrder, BindingResult bindingResult) {
    		if (bindingResult.hasErrors()) { //if the new order has errors, send the user back to correct the mistakes. Invalid fields will be marked.
            return "add-order";
    		}
    	
		orderRepository.save(aniOrder); //save the order to the database.
		return "add-order-success";
    }
    

}

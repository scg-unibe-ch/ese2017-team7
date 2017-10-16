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
		
		model.addAttribute("order", order); //passes the order to change-status.html
		model.addAttribute("users", userRepository.findAll()); //passes all the users to change-status.html. this is needed to select the driver.
    return "change-status";
    }
    
    //Maps post requests for /change-status. 
    @PostMapping("/change-status")
    public String statusSubmit(@Valid @ModelAttribute hello.AniOrder order, BindingResult bindingResult, Model model) {
    		if (bindingResult.hasErrors()) { //check if the changed order is still valid. If it has errors, send the user back to correct them. Wrong values will be marked.
			model.addAttribute("order", order);
			model.addAttribute("users", userRepository.findAll());
        return "change-status";
		}
		
    		orderRepository.save(order); //once the order is valid, save it. This won't create a new entry, but will update the old one with the same id.
        return "change-status-success";
    }

}
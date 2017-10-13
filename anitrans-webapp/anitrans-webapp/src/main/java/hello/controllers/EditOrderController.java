package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Controller
public class EditOrderController {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	Date currentDate = new Date();

    @GetMapping("/edit-order")
    public String orderForm(@RequestParam Integer id, Model model) {
    		hello.AniOrder order;
    		if(id != null) {
    			order  = orderRepository.findById(id);
    		} else {
    			order = new hello.AniOrder();
    		}
    		
    		if(new Date().after(order.getStartTime())) {
    			return "edit-order-forbidden";
    		}
    		
    		model.addAttribute("order", order);
    		model.addAttribute("users", userRepository.findAll());
        return "edit-order";
    }
    
    @PostMapping("/edit-order")
    public String orderSubmit(@Valid @ModelAttribute hello.AniOrder order, BindingResult bindingResult, Model model) {
    		if (bindingResult.hasErrors()) {
    			model.addAttribute("order", order);
    			model.addAttribute("users", userRepository.findAll());
            return "edit-order";
    		}
    		
		orderRepository.save(order);
		return "edit-order-success";
    }

    @GetMapping("/delete-order")
    public String deleteOrder(@RequestParam Integer id, Model model) {

    	    	hello.AniOrder order;
        	if(id != null) {
        		order  = orderRepository.findById(id);
        	} else {
        		order = new hello.AniOrder();
        	}
        	if(new Date().after(order.getStartTime())) {
    			return "edit-order-forbidden";
    		}
        	
        	orderRepository.delete(order);
    	    	return "delete-order-success";

    }
    

}



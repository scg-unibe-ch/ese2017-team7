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

    @GetMapping("/add-order")
    public String orderForm(Model model) {
    		model.addAttribute("aniOrder", new hello.AniOrder()); 
    		model.addAttribute("users", userRepository.findAll());
        return "add-order";
    }

    @PostMapping("/add-order")
    public String orderSubmit(@Valid @ModelAttribute hello.AniOrder aniOrder, BindingResult bindingResult) {
    		if (bindingResult.hasErrors()) {
            return "add-order";
    		}
    	
		orderRepository.save(aniOrder);
		return "add-order-success";
    }
    

}

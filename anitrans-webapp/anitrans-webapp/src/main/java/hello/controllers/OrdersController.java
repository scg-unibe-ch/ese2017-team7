package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private hello.UserRepository userRepository;

    @RequestMapping("/orders")
    	public String orders(Model model) {
    	    model.addAttribute("orders", orderRepository.findAll());
    	    return "orders";
    }

}
package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdersController {
	@Autowired
	private hello.OrderRepository orderRepository;

    @RequestMapping("/orders")
    	public String orders(Model model) {
    	    model.addAttribute("orders", orderRepository.findAll());
    	    return "orders";
    }

}
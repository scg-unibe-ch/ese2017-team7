package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddOrderController {
	@Autowired
	private hello.OrderRepository orderRepository;

    @GetMapping("/add-order")
    public String orderForm(Model model) {
    		model.addAttribute("aniOrder", new hello.AniOrder()); 
        return "add-order";
    }

    @PostMapping("/add-order")
    public String orderSubmit(@ModelAttribute hello.AniOrder aniOrder) {
		orderRepository.save(aniOrder);
		return "add-order-success";
    }

}

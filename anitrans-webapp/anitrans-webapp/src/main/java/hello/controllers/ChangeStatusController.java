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

    @GetMapping("/change-status")
    public String statusForm(@RequestParam Integer id, Model model) {
    	hello.AniOrder order;
		if(id != null) {
			order  = orderRepository.findById(id);
		} else {
			order = new hello.AniOrder();
		}
		
		model.addAttribute("order", order);
		model.addAttribute("users", userRepository.findAll());
    return "change-status";
    }

    @PostMapping("/change-status")
    public String statusSubmit(@Valid @ModelAttribute hello.AniOrder order, BindingResult bindingResult, Model model) {
    		if (bindingResult.hasErrors()) {
			model.addAttribute("order", order);
			model.addAttribute("users", userRepository.findAll());
        return "change-status";
		}
		
    		orderRepository.save(order);
        return "change-status-success";
    }

}
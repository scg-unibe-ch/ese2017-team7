package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddOrderController {

    @GetMapping("/add-order")
    public String orderForm(Model model) {
        model.addAttribute("order", new hello.Order());
        return "add-order";
    }

    @PostMapping("/add-order")
    public String orderSubmit(@ModelAttribute hello.Order order) {
        return "add-order-success";
    }

}
package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangeStatusController {

    @GetMapping("/change-status")
    public String orderForm(Model model) {
        model.addAttribute("order", new hello.Order());
        return "change-status";
    }

    @PostMapping("/change-status")
    public String orderSubmit(@ModelAttribute hello.Order order) {
        return "change-status-success";
    }

}
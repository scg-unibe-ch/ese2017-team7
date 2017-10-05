package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new hello.User());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute hello.User user) {
        return "registration-success";
    }

}
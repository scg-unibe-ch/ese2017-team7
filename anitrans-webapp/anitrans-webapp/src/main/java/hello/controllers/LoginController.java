package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new hello.Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute hello.Login login) {
        return "logout";
    }

}
package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	
	// Maps get requests for /register. 
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new hello.User());
        return "register";
    }
    
    //Maps post requests for /register. This will need to be implemented, so that a new entry in the User table will be created when someone registers.
    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute hello.User user) {
        return "registration-success";
    }

}
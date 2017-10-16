package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	//Maps get requests for /login.
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new hello.User()); //creates a new user. This will need to be changed once the login is implemented.
        return "login";
    }

    //Maps post requests for /login.
    //Login check will need to be implemented here. Only users which are registered in the database may be logged in.
    //Will also need to implement a way to only show certain pages to logged in users.
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute hello.User user) {
        return "logout";
    }

}
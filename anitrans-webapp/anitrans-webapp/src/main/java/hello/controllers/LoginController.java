package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.authentication.*;

@Controller
public class LoginController {
	@Autowired
	private hello.UserRepository userRepository;
	
	
	
	//Maps get requests for /login.
    @GetMapping("/login")
    public String loginForm(Model model) {
    	
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		if (!(auth instanceof AnonymousAuthenticationToken)) {

    			return "logout"; // the user is already logged in, so send him to the logout page.
    		}
    	
        model.addAttribute("login", new hello.Login()); //creates a new user. This will need to be changed once the login is implemented.
        return "login";
    }

   

}
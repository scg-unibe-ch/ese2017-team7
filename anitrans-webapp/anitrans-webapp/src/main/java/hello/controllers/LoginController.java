package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	private hello.UserRepository userRepository;
	
//	Maps get requests for /login.
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new hello.Login()); //creates a new user. This will need to be changed once the login is implemented.
        return "login";
    }

    //Maps post requests for /login.
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute hello.Login login, BindingResult bindingResult, Model model) {
    	
     	if (bindingResult.hasErrors()) { //if the logged in user has errors, send the user back to correct the mistakes. Invalid fields will be marked.
     		model.addAttribute("msg", "Email or password incorrect.");
            return "login";
    		}
    		
    		if(login.getEmail() != null) {
    			hello.User rightUser  = userRepository.findByEmail(login.getEmail()); //finds the user to be logged in in the Database.
    			if(rightUser != null && rightUser.getPassword().equals(login.getPassword())) {
    				model.addAttribute("user", rightUser);
    				return "logout";
    			}
    		}
    		
    		model.addAttribute("msg", "Email or password incorrect.");
    		return "login";
    	
        
    }

}
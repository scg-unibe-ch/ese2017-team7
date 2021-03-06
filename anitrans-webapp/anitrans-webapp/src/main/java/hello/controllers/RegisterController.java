package hello.controllers;

import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.NewUser;
import hello.User;

@Controller
public class RegisterController {
	@Autowired
	private hello.UserRepository userRepository;
	//@Autowired
	@Autowired
	private hello.AddressRepository addressRepository;
	
	// Maps get requests for /register. 
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("newUser", new hello.NewUser());//create a new user and pass it to register.html
        return "register"; //return the template
    }
    
    //Maps post requests for /register. This will need to be implemented, so that a new entry in the User table will be created when someone registers.
    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute hello.NewUser newUser, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) { //if the new user has errors, send the user back to correct the mistakes. Invalid fields will be marked.
            return "register";
    	}
    	
    	if	(userRepository.findByEmail(newUser.getEmail()) != null) {
    		model.addAttribute("errorMsg", "There is already someone registered with that email address.");
    		return "register";
    }
    	hello.Address address = new hello.Address(newUser.getName(), newUser.getStreet(), newUser.getTown(), newUser.getPlz());
    	hello.User user = new hello.User(newUser, address);
    		System.out.println(user.getPassword());
    		
    		addressRepository.save(address); //save the address to the database.
		userRepository.save(user); //save the order to the database.
		model.addAttribute(user);
        return "registration-success"; //return the template
    }
    
  //Maps get requests for /delete-user. The id of the user to be deleted is passed through the URL.
    @GetMapping("/delete-driver")
    public String deleteDriver(@RequestParam Integer id, Model model) {

    	    	User user;
        	if(id != null) {
        		user  = userRepository.findById(id); //finds the user to be deleted.
        	} else {
        		user = new hello.User(); //if it doesn't exist a new user is created.
        	}
        	
        	if(user.getRole().equals("ROLE_ADMIN")) {
        		return "delete-user-forbidden"; //if the user is an admin, it cannot be deleted.
        	}

        	
        	userRepository.delete(user); //delete the user.
        	addressRepository.delete(user.getAddress());
    	    	return "delete-user-success"; //return the template

    }

}
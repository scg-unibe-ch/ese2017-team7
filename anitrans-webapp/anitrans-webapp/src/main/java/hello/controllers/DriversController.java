package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DriversController {
	
	// Maps the /drivers subpage and implements its connection with the database and the "Users" table.
    @RequestMapping("/drivers")
    public String index() {
    	//connection to database nees to be implemented!!
        return "drivers";
    }

}
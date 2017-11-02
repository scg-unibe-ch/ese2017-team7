package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {
	@Autowired
	private hello.VehicleRepository vehicleRepository;
	
	// Maps the /drivers subpage and implements its connection with the database and the "Users" table.
    @RequestMapping("/vehicles")
    public String index(Model model) {
    		model.addAttribute("vehicles", vehicleRepository.findAll()); //Finds all the drivers which are to be displayed in drivers.html
        return "vehicles";
    }

}
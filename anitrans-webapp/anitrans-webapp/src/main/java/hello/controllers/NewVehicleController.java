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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewVehicleController {
	@Autowired
	private hello.VehicleRepository vehicleRepository;
	
	 //Maps get requests for /new-vehicle. 
    @GetMapping("/new-vehicle")
    public String vehicleForm(Model model) {
    		model.addAttribute("vehicle", new hello.Vehicle());  //create a new vehicle
        return "new-vehicle"; //returns the template
    }
    
    //Maps post requests for /new-vehicle
    @PostMapping("/new-vehicle")
    public String vehicleSubmit(@Valid @ModelAttribute hello.Vehicle vehicle, BindingResult bindingResult, Model model) {
    		if	(vehicleRepository.findByName(vehicle.getName()) != null) {
    			model.addAttribute("errorMsg", "There is already a vehicle with that name.");
    			return "new-vehicle";
    		}
    		if (bindingResult.hasErrors()) { //if the new vehicle has errors, send the user back to correct the mistakes. Invalid fields will be marked.
            return "new-vehicle"; //returns the template
    		}
    		
    		vehicle.setImage("images/" + vehicle.getImage());
    		
    		vehicleRepository.save(vehicle); //save the vehicle to the database.
		return "add-vehicle-success"; //returns the template
    }
    
  //Maps get requests for /delete-vehicle. The id of the vehicle to be deleted is passed through the URL.
    @GetMapping("/delete-vehicle")
    public String deleteVehicle(@RequestParam Integer id, Model model) {

    	    	hello.Vehicle vehicle;
        	if(id != null) {
        		vehicle  = vehicleRepository.findById(id); //finds the vehicle to be deleted.
        	} else {
        		vehicle = new hello.Vehicle(); //if it doesn't exist a new order is created.
        	}

        	vehicle.setNumberOfVehicles(vehicle.getNumberOfVehicles() - 1); //decrease the amount of vehicles
        	if(vehicle.getNumberOfVehicles() <=0 ) {
        		vehicleRepository.delete(vehicle); //if no vehicles of this type remain, delete the vehicle type
        		return "delete-vehicle-success";
        	} else {
        		vehicleRepository.save(vehicle); //if there are still vehicles of this type, then save the type back to the database
    	    	return "delete-vehicle-success";
        	}
    }
    
  //Maps get requests for /add-vehicle. The id of the vehicle to be added is passed through the URL.
    @GetMapping("/add-vehicle")
    public String addVehicle(@RequestParam Integer id, Model model) {

    	    	hello.Vehicle vehicle;
        	if(id != null) {
        		vehicle  = vehicleRepository.findById(id); //finds the vehicle to be deleted.
        	} else {
        		vehicle = new hello.Vehicle(); //if it doesn't exist a new order is created.
        	}

        	vehicle.setNumberOfVehicles(vehicle.getNumberOfVehicles() + 1); //decrease the amount of vehicles

        vehicleRepository.save(vehicle); //save the vehicles back to the database
    	    	return "add-vehicle-success";
    }
       

}

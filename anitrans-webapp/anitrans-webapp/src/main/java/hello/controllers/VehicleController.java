package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
public class VehicleController {
	@Autowired
	private hello.VehicleRepository vehicleRepository;
	@Autowired
	hello.CounterService counter;
	
	// Maps the /drivers subpage and implements its connection with the database and the "Users" table.
    @RequestMapping("/vehicles")
    public String index(Model model) {
    		Iterable<hello.Vehicle> vehicles = vehicleRepository.findAll();
    		ArrayList<VehicleType> vehicleTypes = new ArrayList<VehicleType>();
    		
    		for(hello.Vehicle vehicle : vehicles) {
    			VehicleType vehicleType = new VehicleType(vehicle);
    			vehicleTypes.add(vehicleType);
    		}
    		
    		model.addAttribute("vehicles", vehicleTypes);
    		
        return "vehicles";
    }
    
    class VehicleType {
    		hello.Vehicle vehicle;
    		int availableVehicles;
    		
    		public VehicleType(hello.Vehicle vehicle) {
        		Date currentDate = new Date(); //Is automatically set to the current date
    			
    			this.vehicle = vehicle;
    			this.availableVehicles = vehicle.getNumberOfVehicles() - counter.countVehiclesInUse(vehicle, currentDate, -1); //-1 is passed as the order id because there is no order id which is relevant
    		}
    		
    		public hello.Vehicle getVehicle(){
    			return vehicle;
    		}
    		
    		public int getAvailableVehicles() {
    			return availableVehicles;
    		}
    }

}
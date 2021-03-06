package hello.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddOrderController {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.UserRepository userRepository;
	@Autowired
	private hello.AddressRepository addressRepository;
	@Autowired
	private hello.VehicleRepository vehicleRepository;
	@Autowired
	hello.CounterService counter;
	
	 //Maps get requests for /add-order. 
    @GetMapping("/add-order")
    public String orderForm(Model model) {
    		model.addAttribute("newOrder", new hello.NewOrder());  //create a new order and pass it to add-order.html
    		model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
    		model.addAttribute("vehicles", vehicleRepository.findAll()); //find all the vehicles and pass them to add-order.html. This is needed to select the vehicle.
        return "add-order"; //returns the template
    }
    
    //Maps post requests for /add-order
    @PostMapping("/add-order")
    public String orderSubmit(@Valid @ModelAttribute hello.NewOrder order, BindingResult bindingResult, Model model) {
    		hello.Vehicle vehicle = vehicleRepository.findByName(order.getVehicle());
    		hello.User driver = userRepository.findById(order.getDriverId());
    		
    		if(bindingResult.hasErrors()) {
    			model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
    			model.addAttribute("vehicles", vehicleRepository.findAll()); //find all the vehicles and pass them to add-order.html. This is needed to select the vehicle.
    			return "add-order";
    		}
    		
    		//Get the custom errors and if there are any, send the user back to correct his results.
    		//-1 is passed as the order id because there is no order id which is relevant
    		if(bindingResult.hasErrors() || (vehicle != null && counter.countVehiclesInUse(vehicle, order.getUntil(), -1) >= vehicle.getNumberOfVehicles()) || (driver != null && counter.checkIfDriverBusy(driver, order.getUntil(), -1))) {
        		model = getErrors(order, bindingResult, model);
        		model.addAttribute("users", userRepository.findAll()); //find all the users and pass them to add-order.html. This is needed to select the driver.
        		model.addAttribute("vehicles", vehicleRepository.findAll()); //find all the vehicles and pass them to add-order.html. This is needed to select the vehicle.
       		return "add-order";
        	}
    		
    		//create address and order objects from the information provided by the user.
    		hello.Address fromAddress = new hello.Address(order.getFromName(), order.getFromStreet(), order.getFromTown(), order.getFromPlz());
    		hello.Address toAddress = new hello.Address(order.getToName(), order.getToStreet(), order.getToTown(), order.getToPlz());
    		hello.AniOrder aniOrder = new hello.AniOrder(order, fromAddress, toAddress);
    		
    		addressRepository.save(fromAddress); //save the address to the database.
    		addressRepository.save(toAddress); //save the address to the database.
		orderRepository.save(aniOrder); //save the order to the database.
		return "add-order-success"; //returns the template
    }
    
    /*
     * Gets all the custom errors and error messages
     */
    private Model getErrors(@Valid @ModelAttribute hello.NewOrder order, BindingResult bindingResult, Model model) {
    		hello.Vehicle vehicle = vehicleRepository.findByName(order.getVehicle());
    		hello.User driver = userRepository.findById(order.getDriverId());
		
    		if(vehicle != null ) {
    			if(counter.countVehiclesInUse(vehicle, order.getUntil(), -1) >= vehicle.getNumberOfVehicles()) {//-1 is passed as the order id because there is no order id which is relevant
    				model.addAttribute("vehicleError", "The chosen vehicle isn't available on the chosen date.");
    			}
    		}
		
    		if(driver != null) {
    			if(counter.checkIfDriverBusy(driver, order.getUntil(), -1)) {//-1 is passed as the order id because there is no order id which is relevant
    				model.addAttribute("driverError", "The chosen driver isn't available on the chosen date.");
    			}
    		}		
    	
    		return model;
    }
    

}

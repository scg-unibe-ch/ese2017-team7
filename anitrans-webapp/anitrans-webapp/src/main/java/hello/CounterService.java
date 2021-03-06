package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * This service class is used to count things.
 */
@Service
public class CounterService {
	@Autowired
	private hello.OrderRepository orderRepository;
	@Autowired
	private hello.VehicleRepository vehicleRepository;
	@Autowired
	private hello.UserRepository userRepository;
	
	/*
	 * Counts how many of a vehicle type are in use on a specific date
	 */
	public int countVehiclesInUse(hello.Vehicle vehicleType, Date date, int orderId) {
		Iterable<hello.AniOrder> orders = orderRepository.findAll();
		int counter = 0;
		
		/*
		 * Compares the vehicle of every order with the vehicle type. If they're the same, it increases the counter.
		 */
		if(vehicleType != null) {
			for(hello.AniOrder order : orders) {
				hello.Vehicle currentVehicle = vehicleRepository.findByName(order.getVehicle());
				if(currentVehicle != null && (currentVehicle.getId() == vehicleType.getId()) && order.getId() != orderId) {
					if(((date.getTime() - order.getUntil().getTime() < 86400000) && (date.getTime() - order.getUntil().getTime() >= 0)) || ((date.getTime() - order.getUntil().getTime() > -0) && (date.getTime() - order.getUntil().getTime() <= 0))) {
						counter++;
					}	
				}
			}
		}
		
		return counter;
	}
	
	
	/*
	 * Checks if a driver is busy on a specific date.
	 */
	public boolean checkIfDriverBusy(hello.User driver, Date date, int orderId) {
		Iterable<hello.AniOrder> orders = orderRepository.findAll();
		boolean busy = false;
		
		
		/*
		 * Compares the driver of every order with the driver. If they're the same, the driver is busy.
		 */
		if(driver != null) {
			for(hello.AniOrder order : orders) {
				int currentDriverId = order.getDriverId();
				if(currentDriverId != -1) {
					hello.User currentDriver = userRepository.findById(currentDriverId);
					if(currentDriver != null && (currentDriver.getId() == driver.getId())  && order.getId() != orderId) {
						if(((date.getTime() - order.getUntil().getTime() < 86400000) && (date.getTime() - order.getUntil().getTime() >= 0)) || ((date.getTime() - order.getUntil().getTime() > -86400000) && (date.getTime() - order.getUntil().getTime() <= 0))) {
							busy = true;
						}	
					}
				}
				
			}
		}
		
		return busy;
	}
	
}

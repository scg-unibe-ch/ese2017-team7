package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service; 




@Service
public class SortingService {
//sorting logic
	@Autowired
	private hello.OrderRepository orderRepository;
	
	
	public ArrayList<AniOrder> getSuccessful () {
		Iterable<hello.AniOrder> listOrder = orderRepository.findAll();
		ArrayList<hello.AniOrder> allOrders = new ArrayList<>();
		
		//convert Iterable to ArrayList
		for(hello.AniOrder order : listOrder) {
			allOrders.add(order);
		}

		ArrayList<hello.AniOrder> successfulOrders = new ArrayList<>();		
		// go through ArrayList form back to frond, add all delivered orders
		for(int i = allOrders.size(); i >= 0; i--) {
			if(allOrders.get(i).getOrderStatus().equals("delivered")) {
				successfulOrders.add(allOrders.get(i));
			}
		}
		
		return successfulOrders;	//return all the delivered orders

	}
	
	public ArrayList<AniOrder> getUnsuccessful () {
		Iterable<hello.AniOrder> listOrder = orderRepository.findAll();
		ArrayList<hello.AniOrder> allOrders = new ArrayList<>();
		
		//convert Iterable to ArrayList
		for(hello.AniOrder order : listOrder) {
			allOrders.add(order);
		}

		ArrayList<hello.AniOrder> unsuccessfulOrders = new ArrayList<>();			
		// go through ArrayList form back to frond, add all delivered orders
		for(int i = allOrders.size(); i >= 0; i--) {
			if(allOrders.get(i).getOrderStatus().equals("undelivered")) {
				unsuccessfulOrders.add(allOrders.get(i));
			}
		}
		
		return unsuccessfulOrders;	//return all the undelivered orders
		
	}
	
	
<<<<<<< HEAD
	}
=======
	}

//GOALS

//go through with for loop, order.getId()    print(order.getId())

//create one list for completed and one for uncompleted
>>>>>>> 597189cd759a331796289cbf55967b16a81ea994

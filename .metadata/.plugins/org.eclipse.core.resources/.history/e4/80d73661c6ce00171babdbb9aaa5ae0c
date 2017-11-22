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
	
	
//	if (orderStatus == "undelivered") {
//		//sortUndelivered
//	}
//	
//	else {
//		//sortDelivered
//	}
	
	public ArrayList<AniOrder> sort () {
		Iterable<hello.AniOrder> listOrder = orderRepository.findAll();
		
		

		
		List<T> target = new ArrayList<>();				//new conversion
		listOrder.forEachRemaining(target::add);
		
		return list(listOrder);	
		
//		List<hello.AniOrder> = sortedList;
//			return sortedList;

//		for (int i = 0; i < listOrder.length; i++) {
//			System.out.print(listOrder.getId());
		//}
	}
	
	
	}
//go through with for loop, order.getId()    print(order.getId())

//create one list for completed and one for uncompleted
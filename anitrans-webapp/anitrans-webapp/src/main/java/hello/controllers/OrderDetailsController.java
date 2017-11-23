package hello.controllers;

import hello.AniOrder;
import hello.NewOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Controller
public class OrderDetailsController {
	@Autowired
	private hello.OrderRepository orderRepository;
	
	// Maps get requests for /order-details. The id of the order to be viewed needs to be passed through the URL.
	@RequestMapping("/order-details")
    public String orderDetails(@RequestParam Integer id, Model model) {
    		hello.AniOrder order = null;
		if (id != null) {
			order = orderRepository.findById(id); //finds the correct order by id.
		} else {
			return "edit-order-forbidden"; //if the order doesn't exist, can't view it
		}

		hello.NewOrder newOrder = new hello.NewOrder(order, order.getFromAddr(), order.getToAddr());
		model.addAttribute("order", newOrder); //passes the order to order-details.html

        return "order-details"; //return the template
    }
	
	// Maps get requests for /tour-details. The id of the order to be viewed needs to be passed through the URL.
		@RequestMapping("/tour-details")
	    public String tourDetails(@RequestParam Integer id, Model model) {
	    		hello.AniOrder order = null;
			if (id != null) {
				order = orderRepository.findById(id); //finds the correct order by id.
			} else {
				return "edit-order-forbidden"; //if the order doesn't exist, can't view it
			}

			hello.NewOrder newOrder = new hello.NewOrder(order, order.getFromAddr(), order.getToAddr());
			model.addAttribute("order", newOrder); //passes the order to tour-details.html

	        return "tour-details"; //return the template
	    }
    
   
}



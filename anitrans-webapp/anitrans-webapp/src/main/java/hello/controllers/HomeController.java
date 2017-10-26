package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	//Maps all requests of /index. This only needs to return a static page named index.html
    @RequestMapping("/index")
    public String home() {
        return "index";
    }
	
  //Maps all requests of the main address. This only needs to return a static page named index.html
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
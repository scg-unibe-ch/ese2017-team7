package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToursController {

    @RequestMapping("/tours")
    public String index() {
        return "tours";
    }

}
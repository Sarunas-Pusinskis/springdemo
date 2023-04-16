package lt.vcs.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // localhost:8080/
@RequestMapping (path = "/customer") //    http://localhost:8080/customer
public class CustomerController {

//  http://localhost:8080/customer
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage(){
        return "This is my super duper test page";
    }
}

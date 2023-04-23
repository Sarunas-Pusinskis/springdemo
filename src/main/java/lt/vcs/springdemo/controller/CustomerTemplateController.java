package lt.vcs.springdemo.controller;

import lt.vcs.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path = "/templates/customer")
public class CustomerTemplateController {

    @Autowired
    private CustomerService customerService;

    //  http://localhost:8080/templates/customer/test
    @GetMapping(path = "/test")
    public String getTestPage() {
        return "/test/test_page";
    }


}

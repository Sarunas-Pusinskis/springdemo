package lt.vcs.springdemo.controller;

import lt.vcs.springdemo.repository.Customer;
import lt.vcs.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // localhost:8080/
@RequestMapping (path = "/customer") //    http://localhost:8080/customer
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //  http://localhost:8080/customer/test
    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage(){
        return "This is my super duper test page";
    }

    //  http://localhost:8080/customer/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //  http://localhost:8080/customer/103
    @GetMapping(path = "/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    //  http://localhost:8080/customer/customised/103
    @GetMapping(path = "/customised/{id}")
    public @ResponseBody Customer getCustomerByIdCustomised(@PathVariable int id){
        return customerService.getCustomerByIdCustomised(id);
    }

    //  http://localhost:8080/customer/name/toy
    @GetMapping(path = "/name/{name}")
    public @ResponseBody List<Customer> getCustomersByNameLike(@PathVariable String name){
        return customerService.getCustomersByNameLike("%" + name + "%");
    }

    //  http://localhost:8080/customer/customised/name/toy
    @GetMapping(path = "/customised/name/{name}")
    public @ResponseBody List<Customer> getCustomersByName(@PathVariable String name){
        return customerService.getCustomersByName("%" + name + "%");
    }


}

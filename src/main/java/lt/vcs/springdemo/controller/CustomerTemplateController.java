package lt.vcs.springdemo.controller;

import lt.vcs.springdemo.repository.Customer;
import lt.vcs.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

//  http://localhost:8080/templates/customer/firstpage/103
    @GetMapping(path = "/firstpage/{id}")
    public String getCustomerDetailsForFirsPage(@PathVariable int id, Model model) {

        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("company_name", customer.getCustomerName());
        model.addAttribute("contact_last_name", customer.getContactLastName());
        model.addAttribute("contact_first_name", customer.getContactFirstName());
        model.addAttribute("country", customer.getCountry());

        return "/test/firstpage";
    }

    //  http://localhost:8080/templates/customer/firstpage/all
    @GetMapping(path = "/firstpage/all")
    public String getCustomersListForFirsPage(Model model) {

        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("key_customers_list", customers);

        return "/test/firstpage_customers_list";
    }


}

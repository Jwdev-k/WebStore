package com.naka.webstore.controller;

import com.naka.webstore.domain.Customer;
import com.naka.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String list(Model model) {
        model.addAttribute("customers",
                customerService.getAllCustomers());
        return "views/customers";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        return "views/addCustomer";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addCustomer(newCustomer);
        return "redirect:/customers";
    }


}

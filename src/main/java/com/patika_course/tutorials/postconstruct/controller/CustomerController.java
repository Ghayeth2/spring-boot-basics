package com.patika_course.tutorials.postconstruct.controller;

import com.patika_course.tutorials.postconstruct.business.CustomerManager;
import com.patika_course.tutorials.postconstruct.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/postconstruct")
public class CustomerController {
    @Autowired
    private CustomerManager customerManager;
    public CustomerController() {
        /*
            As shown in terminal when run the application
            a Null Pointer Exception was thrown due to the
            yet non injected bean of CustomerManager
            During initializing Constructor of CustomerContoller will be
            called before the the bean being injected. So it will be used
            with null data.
            To avoid that from happening we use @PostConstruct which will not let
            the method work till all Beans are injected.

            We don't see this in case of Https Requests bcz then all Beans will be
            injected. But in some cases we might need the System to run some
            code depending on some Beans but before getting Https Requests.

             System.out.println(customerManager.getCustomer());

         */
        System.out.println("Customer Controller Constructor");
    }

    @PostConstruct
    @GetMapping("/getCustomer")
    public Customer getCustomer(){
        System.out.println(customerManager.getCustomer());
        return customerManager.getCustomer();
    }
}

package com.patika_course.tutorials.postconstruct.business;

import com.patika_course.tutorials.postconstruct.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {
    public CustomerManager() {
        System.out.println("Customer Manager Constructor");
    }

    public Customer getCustomer(){
        return Customer.builder()
                    .fullName("GHAYETH AL MASRI").id(1001)
                .build();
    }
}

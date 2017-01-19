package com.example.custom.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import com.example.pojo.Dog;



public class MyProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

       System.out.println( exchange.getIn().getBody(Dog.class).getName());
    }
}




    /*@Override
    public void process(Exchange exchange) throws Exception {

        System.out.println( exchange.getIn().getBody(Dog.class).getName());
    }*/
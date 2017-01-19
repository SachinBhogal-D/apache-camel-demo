package com.example.mybean;


import com.example.OrderItems;
import com.example.pojo.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBean {

    @Autowired
    ObjectMapper mapper ;

    public void invoke( Exchange ex){
        String abc=null;
        try {
           // order.getPizza().getName();
           abc= mapper.writeValueAsString(ex.getIn().getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
     //   System.out.println(order);
        ex.getIn().setBody(abc);
       // System.out.println(ex.getIn().getBody()+"----------------");

    }

    public void invoke1(Dog dog, Exchange ex){
        String abc=null;
        try {
            dog.setName("Jackei");
            abc= mapper.writeValueAsString(dog);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(dog);
        ex.getIn().setBody(abc);

    }


    public void invoke2(com.example.Order order, Exchange ex){

        System.out.println(order.getOrderItemsList().size());
    }

    public List<OrderItems> splitterMethod(com.example.Order order){

        return order.getOrderItemsList();

    }


    public void invoke3(OrderItems order , Exchange ex){

        System.out.println("IT is here in order items"+order.toString());


    }

    public boolean contentBasedRouter(OrderItems orderItems){

        if(orderItems.getItemType().equalsIgnoreCase("Food"))
            return true ;
        if(orderItems.getItemType().equalsIgnoreCase("Bevarages"))
            return false;

        return false;

    }


}

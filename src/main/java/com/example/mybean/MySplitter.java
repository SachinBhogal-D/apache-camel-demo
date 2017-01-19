package com.example.mybean;

import com.example.orders.Order;
import com.example.orders.Pizza;


public class MySplitter {


    public Pizza returnPizza(Order order){

        return order.getPizza();
    }
}

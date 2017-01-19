package com.example.orders;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Component
@XmlRootElement
public class Order {

    private Pizza pizza;

    private Burger burger;


    public Pizza getPizza() {
        return pizza;
    }

    @XmlElement
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Burger getBurger() {
        return burger;
    }

    @XmlElement
    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza +
                ", burger=" + burger +
                '}';
    }
}

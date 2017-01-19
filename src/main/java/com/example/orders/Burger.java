package com.example.orders;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;


@Component
public class Burger {

    private String name;
    private String type;
    private Float price;
    private Integer quantity;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @XmlElement
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

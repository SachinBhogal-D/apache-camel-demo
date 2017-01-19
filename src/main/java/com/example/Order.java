package com.example;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement
public class Order {


    private List<OrderItems> orderItemsList ;
    private Integer customerId;

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    @XmlElement
    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

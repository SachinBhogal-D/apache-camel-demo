package com.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class OrderItems {

        private String itemType;
        private Integer quantity;
        private String extraInfo;


    public String getItemType() {
        return itemType;
    }

    @XmlElement
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @XmlElement
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    @XmlElement
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


    @Override
    public String toString() {
        return "OrderItems{" +
                "itemType='" + itemType + '\'' +
                ", quantity=" + quantity +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}

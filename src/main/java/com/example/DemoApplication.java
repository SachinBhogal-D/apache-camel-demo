package com.example;

import org.apache.camel.routepolicy.quartz.SimpleScheduledRoutePolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
    public SimpleScheduledRoutePolicy shedulePolicy(){
        SimpleScheduledRoutePolicy policy =new  SimpleScheduledRoutePolicy();
        long startTime = System.currentTimeMillis() + 3000L;
        policy.setRouteStartDate(new Date(startTime));
        policy.setRouteSuspendDate(new Date(startTime+9000L));
        policy.setRouteStartRepeatCount(1);
        policy.setRouteStartRepeatInterval(3000);

        return policy;
    }


    /*@Bean
    public String demo(){
        try {
            Order order = new Order();
            order.setCustomerId(1234);
            OrderItems orderItems = new OrderItems();
            orderItems.setItemType("Bevareges");
            orderItems.setQuantity(2);

            OrderItems orderItems1 = new OrderItems();
            orderItems.setItemType("Food");
            orderItems.setQuantity(2);
            List<OrderItems> orderItemsList = new ArrayList<OrderItems>();
            orderItemsList.add(orderItems);
            orderItemsList.add(orderItems1);
            order.setOrderItemsList(orderItemsList);
            System.out.println(order.getOrderItemsList().size());



            JAXBContext context = JAXBContext.newInstance(Order.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter wr = new StringWriter();
            marshaller.marshal(order,wr);
            System.out.println(wr.toString());


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }*/
}

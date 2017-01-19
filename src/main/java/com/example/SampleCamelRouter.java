package com.example;

import com.example.custom.processor.MyProcessor;
import com.example.mybean.MyBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.routepolicy.quartz.SimpleScheduledRoutePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

@Component
public class SampleCamelRouter extends RouteBuilder {

   // XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
    MyProcessor my = new MyProcessor();

    @Autowired
    SimpleScheduledRoutePolicy policy;



    @Override
    public void configure() throws Exception {

       //JAXBContext context =  JAXBContext.newInstance(com.example.Order.class);
       // JaxbDataFormat df = new JaxbDataFormat(context);
        //df.setIgnoreJAXBElement(false);



        from("ftp://localhost:21/temp?username=delhivery&password=welcome@123&autoCreate=false&noop=true&idempotentKey=${file:name}-${file:modified}&fileName=demo.txt")
                .split().method(MyBean.class,"splitterMethod") //.unmarshal(df)
                   .log("After Splitting====>>>>${body}")
                .choice()
                    .when().xpath("/orderItems/itemType[text()='Food']")
                        .to("file://demo1.txt")
                    .when().xpath("/orderItems/itemType[text()='Bevarages']")
                        .to("file://demot2.txt");


    }
}


//.when(method(MyBean.class,"contentBasedRouter"))
// //.bean(MyBean.class,"invoke3")//.aggregate(new CustomAggregationStrategy())
//to("cxfrs:http://localhost:8081/demo/web")


   /* @Override
    public void configure() throws Exception {

        *//*CronScheduledRoutePolicy startPolicy = new CronScheduledRoutePolicy();
        long startTime = System.currentTimeMillis() + 3000L;
        startPolicy.setRouteStartTime("0 48 13 * * ?");*//*
        JaxbDataFormat df = new JaxbDataFormat("com.example.pojo");
        //df.setIgnoreJAXBElement(false);
        from("ftp://localhost:21/temp?username=delhivery&password=welcome@123").unmarshal(df).process(my)
                //.unmarshal(xmlJsonFormat).process(my).routeId("test").routePolicy(startPolicy).autoStartup(false)
                // .transform(method("myBean", "saySomething"))
                .to("file://demo1.txt");

    }*/



    /*from("ftp://localhost:21/temp?username=delhivery&password=welcome@123")
                .unmarshal(df)
                        .bean(MyBean.class,"invoke")
        .to("file://demo1.txt");*/





    /*onException(Exception.class)
                .handled(true)
                        .log("IOException occurred due: ${exception.message}")
                        // as we handle the exception we can send it to direct:file-error,
                        // where we could send out alerts or whatever we want
                        .to("direct:file-error");

                        // special route that handles file errors
                        from("direct:file-error")
                        .log("File error route triggered to deal with exception ${exception?.class}")
                        // as this is based on unit test just transform a message and send it to a mock
                        .transform().simple("Error ${exception.message}")
                        .to("mock:error");
*/
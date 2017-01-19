package com.example.myconsumerpollstrategy;/*
package com.example.com.example.myconsumerpollstrategy;

import org.apache.camel.spi.PollingConsumerPollStrategy;
import org.apache.camel.Consumer;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import java.util.concurrent.CountDownLatch;
import org.apache.camel.routepolicy.quartz.CronScheduledRoutePolicy;


public class MyPollStrategy implements PollingConsumerPollStrategy {
    private static int maxPolls;

    private final CountDownLatch latch = new CountDownLatch(1);

    public boolean begin(Consumer consumer, Endpoint endpoint) {
        return true;
    }

    public void commit(Consumer consumer, Endpoint endpoint, int polledMessages) {
        if (polledMessages > maxPolls) {
            maxPolls = polledMessages;
        }
        latch.countDown();
    }

    public boolean rollback(Consumer consumer, Endpoint endpoint, int retryCounter, Exception cause) throws Exception {
        return false;
    }
}

*/

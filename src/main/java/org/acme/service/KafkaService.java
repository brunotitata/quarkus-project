package org.acme.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.smallrye.reactive.messaging.annotations.Channel;

public class KafkaService {

    @ApplicationScoped
    public static class PriceGenerator {

        private Random random = new Random();

        @Outgoing("generated-price")
        public Flowable<Integer> generate() {
            return Flowable.interval(1, TimeUnit.SECONDS).map(tick -> random.nextInt(100));
        }

    }

    @ApplicationScoped
    public static class PriceConverter {

        private static final double CONVERSION_RATE = 0.88;

        @Incoming("prices")
        @Outgoing("my-data-stream")
        @Broadcast
        public double process(int priceInUsd) {
            return priceInUsd * CONVERSION_RATE;
        }

    }

    @Path("/prices")
    public static class PriceResource {

        @Inject
        @Channel("my-data-stream")
        Publisher<Double> prices;

        @GET
        @Path("/stream")
        @Produces(MediaType.SERVER_SENT_EVENTS)
        @SseElementType(MediaType.APPLICATION_JSON)
        public Publisher<Double> stream() {
            return prices;
        }
    }

}
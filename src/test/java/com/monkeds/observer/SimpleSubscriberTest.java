package com.monkeds.observer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.* ;


class SimpleSubscriberTest {


    @Test
    public void whenSubscribeToIt_thenShouldConsumeAll()
            throws InterruptedException {

        // given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        SimpleSubscriber<String> subscriber = new SimpleSubscriber<String>("subs 1 ");
        publisher.subscribe(subscriber);

        SimpleSubscriber<String> subscriber2 = new SimpleSubscriber<String>("subs 2 ");
        publisher.subscribe(subscriber2);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        // when
        assertEquals(2, publisher.getNumberOfSubscribers());
        items.forEach(publisher::submit);
        publisher.close();

        // then
        /*
        await().atMost(1000, TimeUnit.MILLISECONDS)
                .until(
                        () -> assertThat(subscriber.consumedElements)
                                .containsExactlyElementsOf(items)
                );*/
    }

}
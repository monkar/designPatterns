package com.monkeds.observer;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public class SimpleSubscriber<T> implements Flow.Subscriber<T> {
    Flow.Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();
    String name;

    public SimpleSubscriber(String name) {
        this.name = name;
    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); //indica que esl subscriptor esta listo para mas mensajes
    }

    @Override
    public void onNext(T item) {
        System.out.println(name+" Got: "+item);
        consumedElements.add(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done.");
    }

    public List<T> getConsumedElements() {
        return consumedElements;
    }
}

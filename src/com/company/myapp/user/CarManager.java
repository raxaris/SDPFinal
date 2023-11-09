package com.company.myapp.user;

import com.company.myapp.user.inferfaces.IPublisher;
import com.company.myapp.user.inferfaces.IUser;

import java.util.ArrayList;

public class CarManager implements IPublisher {
    private final ArrayList<IUser> subscribers;

    public CarManager() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(IUser subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(IUser subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String newInfo) {
        for(IUser subscriber : subscribers) {
            subscriber.update(newInfo);
        }
    }
}
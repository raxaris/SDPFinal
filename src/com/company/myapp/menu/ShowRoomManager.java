package com.company.myapp.menu;

import com.company.myapp.cars.Car;
import com.company.myapp.user.inferfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class ShowRoomManager{
    private final ArrayList<IUser> subscribers;

    public ShowRoomManager() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(IUser subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(IUser subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String newInfo) {
        for(IUser subscriber : subscribers) {
            subscriber.update(newInfo);
        }
    }

}
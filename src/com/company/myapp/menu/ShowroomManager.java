package com.company.myapp.menu;

import com.company.myapp.user.inferfaces.IUser;

import java.util.ArrayList;

public class ShowroomManager {
    private final ArrayList<IUser> subscribers;

    public ShowroomManager() {
        this.subscribers = new ArrayList<>();
    }

    public boolean subscribe(IUser subscriber) {
        for (IUser existingSubscriber : subscribers) {
            if (existingSubscriber.getId() == (subscriber.getId())) {
                System.out.println("User login: " + subscriber.getLogin() + " already subscribed!");
                return false;
            }
        }
        subscribers.add(subscriber);
        return true;
    }

    public void unSubscribe(IUser subscriber) {
        subscribers.remove(subscriber);
    }

    public void unSubscribeByID(int id) {
        subscribers.remove(id);
    }

    public void notifySubscribers(String newInfo) {
        for(IUser subscriber : subscribers) {
            subscriber.update(newInfo);
        }
    }

    public void displaySubscribers(){
        if (subscribers.isEmpty()) {
            System.out.println("No subscribers at the moment.");
            return;
        }

        System.out.println("List of Subscribers:");
        int i = 0;
        for (IUser subscriber : subscribers) {
            System.out.println(i++ + ". " + subscriber.getLogin());
        }
    }
}
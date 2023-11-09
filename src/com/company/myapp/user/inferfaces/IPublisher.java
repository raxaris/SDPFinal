package com.company.myapp.user.inferfaces;

public interface IPublisher {
    void subscribe(IUser subscriber);
    void unSubscribe(IUser subscriber);
    void notifySubscribers(String message);
}
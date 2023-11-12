package com.company.myapp.application.admin;

import com.company.myapp.application.InputUtils;
import com.company.myapp.controllers.UserController;
import com.company.myapp.menu.Showroom;
import com.company.myapp.user.User;
import com.company.myapp.user.inferfaces.IUser;

public class ShowroomManagerMenuHandler {

    private final Showroom showRoom;
    private final UserController userController;

    public ShowroomManagerMenuHandler(Showroom showRoom, UserController userController) {
        this.showRoom = showRoom;
        this.userController = userController;
    }

    public void processShowRoomManagerMenu() {
        while (true) {
            int option = InputUtils.getMenuInput("\nSelect option:\n1. Add subscriber\n2. Remove subscriber\n3. Display subscribers\n4. Notify subscribers\n0. Exit\nEnter option (1 to 4): ", 4);
            switch (option) {
                case 1:
                    addSubscriber();
                    break;
                case 2:
                    removeSubscriberMenu();
                    break;
                case 3:
                    displaySubscribers();
                    break;
                case 4:
                    notifySubscribers();
                    break;
                case 0:
                    System.out.println("Exiting the Showroom Manager menu. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option (1 to 4).");
            }
            System.out.println("*************************");
        }
    }

    private void addSubscriber() {
        int id = InputUtils.getUserInputInt("User ID: ");
        IUser subscriber = userController.getUser(id);
        if (subscriber != null) {
            boolean status = showRoom.getShowRoomManager().subscribe(subscriber);
            if (status) System.out.println("User was successfully subscribed");
        } else {
            System.out.println("Error: User not found.");
        }
    }

    private void removeSubscriberMenu() {
        int option = InputUtils.getMenuInput("\nSelect option:\n1. Remove by user ID\n2. Remove by subscriber ID\n0. Exit\nEnter option (1 or 2): ", 2);
        switch (option) {
            case 1:
                removeSubscriber();
                break;
            case 2:
                removeSubscriberByID();
                break;
            case 0:
                System.out.println("Exiting the Remove Subscriber menu. Goodbye!");
                return;
            default:
                System.out.println("Invalid option. Please select a valid option (1 or 2).");
        }
    }

    private void removeSubscriber() {
        int id = InputUtils.getUserInputInt("User ID: ");
        User subscriber = userController.getUser(id);
        if (subscriber != null) {
            showRoom.getShowRoomManager().unSubscribe(subscriber);
            System.out.println("User was successfully unsubscribed");
        } else {
            System.out.println("Error: User not found.");
        }
    }

    private void removeSubscriberByID() {
        int id = InputUtils.getUserInputInt("User ID: ");
        showRoom.getShowRoomManager().unSubscribeByID(id);
        System.out.println("User was successfully unsubscribed");
    }

    private void displaySubscribers() {
        showRoom.getShowRoomManager().displaySubscribers();
    }

    private void notifySubscribers() {
        String message = InputUtils.getUserInputLine("Enter a message: ");
        showRoom.getShowRoomManager().notifySubscribers(message);
    }
}

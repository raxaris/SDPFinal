package com.company.myapp.application.admin;

import com.company.myapp.application.InputUtils;
import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.controllers.CarController;
import com.company.myapp.controllers.UserController;
import com.company.myapp.menu.Showroom;
import com.company.myapp.user.User;


public class AdminApplication implements IApplicationStrategy {
    private final CarController carController;
    private final UserController userController;
    private User user;
    private final Showroom showRoom;
    private final CarMenuHandler carMenuHandler;
    private final UserMenuHandler userMenuHandler;
    private final ShowroomManagerMenuHandler showRoomManagerMenuHandler;


    public AdminApplication(CarController carController, UserController userController, User user) {
        this.carController = carController;
        this.userController = userController;
        this.user = user;
        this.showRoom = new Showroom(carController);
        this.carMenuHandler = new CarMenuHandler(carController);
        this.userMenuHandler = new UserMenuHandler(userController);
        this.showRoomManagerMenuHandler = new ShowroomManagerMenuHandler(showRoom, userController);
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        System.out.println("""         
                   ♠♚ \u001B[1mWelcome back Admin.\u001B[1m ♚♠\s        
                ░░░░░░░░░░░░░▐█▄▄▄█▌░░░░░░░░░░░░░░
                ░░░░░░░░░░░░▄███████▄░░░░░░░░░░░░░
                ░░░░░░░░░▄███░▀▀▀▀▀░███▄░░░░░░░░░░
                ░░░░░░░░░░▀███████████▀░░░░░░░░░░░
                ░░░░░░░░░░░░█░▄▄▄▄▄░█░░░░░░░░░░░░░
                ░░░░░░░░░░▄██░▀▀░▀▀░██▄░░░░░░░░░░░
                ░░░░░░░░▄█████░░░░░█████▄░░░░░░░░░
                ░░░░░░░░░▀█████▄▄▄█████▀░░░░░░░░░░
                ░░░░░░░░░░░▀█████████▀░░░░░░░░░░░░
                ░░░░░░░░░░░░░▀▀▀▀▀▀▀░░░░░░░░░░░░░░              
                """);
        while (true) {
            int option = InputUtils.getMenuInput("Select option:\n1. User menu\n2. Car menu\n3. Show room manager menu\n0. Exit\nEnter option (1 or 2): ", 3);
            switch (option) {
                case 1 -> userMenuHandler.processUserMenu();
                case 2 -> carMenuHandler.processCarMenu();
                case 3 -> showRoomManagerMenuHandler.processShowRoomManagerMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1, 2, 3 or 0).");
            }
            System.out.println("*************************");
        }
    }
}

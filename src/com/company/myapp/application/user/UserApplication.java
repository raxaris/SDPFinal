package com.company.myapp.application.user;

import com.company.myapp.application.InputUtils;
import com.company.myapp.application.interfaces.IApplicationStrategy;
import com.company.myapp.controllers.CarController;
import com.company.myapp.user.User;

public class UserApplication implements IApplicationStrategy{
    private final CarController carController;
    private User user;
    private final ShowroomMenuHandler showRoomMenuHandler;
    private final CartMenuHandler cartMenuHandler;
    private final CarCreationMenuHandler carCreationMenuHandler;

    public UserApplication(CarController carController, User user) {
        this.carController = carController;
        this.user = user;
        this.showRoomMenuHandler = new ShowroomMenuHandler(carController);
        this.cartMenuHandler = new CartMenuHandler(user.getCart(),carController);
        this.carCreationMenuHandler = new CarCreationMenuHandler(carController);
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public void start() {
        System.out.println("""
                
                Welcome to AliSar Car Company!
                 ─────▄───▄
                ─▄█▄─█▀█▀█─▄█▄
                ▀▀████▄█▄████▀▀
                ─────▀█▀█▀
                """);
        while (true) {
            int option = InputUtils.getMenuInput("Select option:\n1. Create a car\n2. Show showroom\n3. Show cart\n0. Exit\nEnter option (1 or 3): ", 3);
            switch (option) {
                case 1 -> carCreationMenuHandler.processCarMenu();
                case 2 -> showRoomMenuHandler.processShowroomMenu();
                case 3 -> cartMenuHandler.processCartMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 3).");
            }

            System.out.println("*************************");
        }
    }
}
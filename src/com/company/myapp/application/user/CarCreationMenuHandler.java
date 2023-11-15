package com.company.myapp.application.user;


import com.company.myapp.application.InputUtils;
import com.company.myapp.cars.Car;
import com.company.myapp.controllers.CarController;
import java.util.*;

public class CarCreationMenuHandler {
    private final CarController carController;
    private Car car;
    public static final List<String> colors = new ArrayList<>(List.of(
            "Racing Yellow",
            "Jet Black",
            "Arctic White",
            "Deep Blue",
            "Fire Red",
            "Silver Metallic",
            "Forest Green",
            "Sunset Orange",
            "Midnight Purple",
            "Electric Blue"
    ));

    public CarCreationMenuHandler(CarController carController) {
        this.carController = carController;
    }

    public void processCarMenu() {
        System.out.println();
        while (true) {
            int option = InputUtils.getMenuInput("Select option:\n1. Open car configurator\n2. Customize your car\n3. Check your car\n0. Exit\nEnter option (1 or 3): ", 3);
            switch (option) {
                case 1 -> configuratorMenu();
                case 2 -> customMenu();
                case 3 -> showCarMenu();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please select a valid option (1 or 3).");
            }

            System.out.println("*************************");
        }
    }
    public void configuratorMenu(){
        List<String> brands = carController.getAllBrands();
        System.out.println("Brands: ");
        displayList(brands);
        int option = InputUtils.getUserInputInt("Select brand: ");
        System.out.println();
        String brand = brands.get(option - 1);

        List<String> models = carController.getModelsByBrand(brand);
        System.out.println("Available " + brand + " models: ");
        displayList(models);
        option = InputUtils.getUserInputInt("Select model: ");
        System.out.println();
        String model = models.get(option-1);

        List<String> mods = carController.getModificationsByBrandAndModel(brand, model);
        System.out.println(brand + " " + model + " modifications: ");
        displayList(mods);
        option = InputUtils.getUserInputInt("Select modification: ");
        System.out.println();
        String modification = mods.get(option - 1);
        car = carController.getCarByFullName(brand, model, modification);

        System.out.println("Available colors: ");
        displayList(colors);
        option = InputUtils.getUserInputInt("Select color: ");
        System.out.println();
        String color = colors.get(option - 1);
        car.setColor(color);
        showCarMenu();
    }

    public void customMenu(){

    }

    public void showCarMenu(){
        if(car != null){
            System.out.println("\nYour car: ");
            System.out.println(car.toString());
        } else {
            System.out.println("\nYou dont have any car yet T-T");
        }
    }

    public void displayList(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }

}

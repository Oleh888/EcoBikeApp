package com.dev;

import com.dev.model.EcoBike;
import java.util.Scanner;

public class ConsoleHandler {
    public static void makeChoice(String path) {
        String command = new Scanner(System.in).nextLine();
        switch (command) {
            case "1":
                Storage.getBikes().forEach(System.out::println);
                break;
            case "2":
                System.out.println("Please provide info about folding bike in format: "
                        + "\nbrand; size of the wheels (in inch); "
                                + "number of gears; weight of the bike (in grams); \navailability"
                                + " of lights at front and back (TRUE/FALSE); color; price"
                                + "Example: \nFormula; 16; 21; 12200; true; flame; 269");
                String foldingBikeInfo = new Scanner(System.in).nextLine();
                try {
                    FileHandler.addBike("FOLDING BIKE " + foldingBikeInfo, path);
                } catch (Exception e) {
                    System.out.println("Data is not correct! Please, repeat operation.");
                    makeChoice(path);
                }
                break;
            case "3":
                System.out.println("Please provide info about speed electric bike in format: "
                        + "\nbrand; size of the wheels (in inch); "
                        + "maximum speed (in km/h); " + "weight of the bike (in grams)"
                        + ";\navailability of lights at front and back (TRUE/FALSE); "
                        + "battery capacity (in mAh); color; price"
                        + "Example: \nSmart; 40; 9600; false; 13000; brown; 1065");
                String speedElectricBikeInfo = new Scanner(System.in).nextLine();
                try {
                    FileHandler.addBike("SPEEDELEC " + speedElectricBikeInfo, path);
                } catch (Exception e) {
                    System.out.println("Data is not correct! Please, repeat operation.");
                    makeChoice(path);
                }
                break;
            case "4":
                System.out.println("Please provide info about electric bike in format: "
                        + "\nbrand; size of the wheels (in inch); "
                        + "maximum speed (in km/h); " + "weight of the bike (in grams)"
                        + "; \navailability of lights at front and back (TRUE/FALSE); "
                        + "battery capacity (in mAh); color; price"
                        + "\nExample: \nSmart; 40; 9600; false; 13000; brown; 1065");
                String electricBikeInfo = new Scanner(System.in).nextLine();
                try {
                    FileHandler.addBike("E-BIKE " + electricBikeInfo, path);
                } catch (Exception e) {
                    System.out.println("Data is not correct! Please, repeat operation.");
                    makeChoice(path);
                }
                break;
            case "5":
                System.out.println("Please provide brand that you want to get");
                String brand = new Scanner(System.in).nextLine();
                for (Object bike : Storage.getBikes()) {
                    EcoBike ecoBike = (EcoBike) bike;
                    if (ecoBike.getBrand().equalsIgnoreCase(brand)) {
                        System.out.println(ecoBike);
                        break;
                    }
                }
                System.out.println("There is not bike with this brand: " + brand
                        + ". Please, try one more time.");
                makeChoice(path);
                break;
            case "6":
                System.out.println("If you want to write some info about eco-bike to the file, "
                        + "you should chose particular bike and option 2, 3 or 4");
                makeChoice(path);
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("It's not right option! You can chose option from only 1 to 7!");
                makeChoice(path);
        }
    }
}

package com.dev;

import com.dev.model.ElectricBike;
import com.dev.model.FoldingBike;
import com.dev.model.SpeedElectricBike;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileHandler {
    public static void readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                createBike(line);
            }
        } catch (IOException e) {
            System.out.println("Something is wrong, please try again.");
        }
    }

    private static void createBike(String line) {
        if (line.startsWith("FOLDING")) {
            line = line.replaceFirst(" ", "");
        }
        List<String> characteristic = Arrays.stream(line.split(";"))
                .map(String::trim).collect(Collectors.toList());
        String[] nameAndBrand = characteristic.get(0).split(" ");
        String bikeName = nameAndBrand[0];
        String brand = nameAndBrand[1];
        if ("FOLDINGBIKE".equals(bikeName)) {
            FoldingBike foldingBike = new FoldingBike();
            foldingBike.setBrand(brand);
            foldingBike.setSizeOfWheels(Double.parseDouble(characteristic.get(1)));
            foldingBike.setNumberOfGears(Integer.parseInt(characteristic.get(2)));
            foldingBike.setWeight(Double.parseDouble(characteristic.get(3)));
            foldingBike.setWithLight(Boolean.getBoolean(characteristic.get(4)));
            foldingBike.setColor(characteristic.get(5));
            foldingBike.setPrice(Double.parseDouble(characteristic.get(6)));
            Storage.getBikes().add(foldingBike);
        } else if ("E-BIKE".equals(bikeName)) {
            ElectricBike electricBike = new ElectricBike();
            electricBike.setBrand(brand);
            electricBike.setMaxSpeed(Double.parseDouble(characteristic.get(1)));
            electricBike.setWeight(Double.parseDouble(characteristic.get(2)));
            electricBike.setWithLight(Boolean.parseBoolean(characteristic.get(3)));
            electricBike.setBatteryCapacity(Double.parseDouble(characteristic.get(4)));
            electricBike.setColor(characteristic.get(5));
            electricBike.setPrice(Double.parseDouble(characteristic.get(6)));
            Storage.getBikes().add(electricBike);
        } else if ("SPEEDELEC".equals(bikeName)) {
            SpeedElectricBike speedElectricBike = new SpeedElectricBike();
            speedElectricBike.setBrand(brand);
            speedElectricBike.setMaxSpeed(Double.parseDouble(characteristic.get(1)));
            speedElectricBike.setWeight(Double.parseDouble(characteristic.get(2)));
            speedElectricBike.setWithLight(Boolean.parseBoolean(characteristic.get(3)));
            speedElectricBike.setBatteryCapacity(Double.parseDouble(characteristic.get(4)));
            speedElectricBike.setColor(characteristic.get(5));
            speedElectricBike.setPrice(Double.parseDouble(characteristic.get(6)));
            Storage.getBikes().add(speedElectricBike);
        }
    }

    public static void addBike(String line, String path) {
        createBike(line);
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Files.write(Paths.get(path), line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Something is wrong, please try again.");
        }
    }

    public static String getPath() {
        System.out.println("Provide directory to your file");
        String path = new Scanner(System.in).nextLine();
        File file = new File(path);
        if (!file.isFile()) {
            System.out.println("There is not such file,"
                    + " please check if file exist and repeat please.");
            getPath();
        }
        FileHandler.readFromFile(path);
        return path;
    }
}

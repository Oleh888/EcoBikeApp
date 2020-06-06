package com.dev;

//import com.dev.model.EcoBike;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileNotFoundException;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final String FILE_TEST1 = "test1.txt";
    private static final String FILE_TEST2 = "test2.txt";
    private static final String FILE_TEST3 = "test3.txt";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        Storage.getBikes().clear();
    }

    @Test
    public void getPathIsOk() {
        System.setIn(new ByteArrayInputStream(FILE_TEST1.getBytes()));
        Assert.assertEquals(FILE_TEST1, FileHandler.getPath());
    }

    @Test
    public void readFromFileIsOk() {
        String expected = "SPEEDELECE Booster with 13200.0 mAh battery and  no head/tail light.\n"
                + "Price: 1279.0 euros.\r\n"
                + "E-BIKE Lankeleisi with 30000.0 mAh battery and  no head/tail light.\n"
                + "Price: 859.0 euros.\r\n"
                + "FOLDING BIKE Benetti with 27 gear(s) and no head/tail light.\n"
                + "Price: 1009.0 euros.\r\n";
        FileHandler.readFromFile(FILE_TEST2);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ConsoleHandler.makeChoice(FILE_TEST2);
        Assert.assertEquals(expected, output.toString());
    }
//
//    @Test
//    public void addNewFoldingBikeIsOk() throws FileNotFoundException {
//        String input = "Formula; 16; 21; 12200; true; flame; 269";
//        FileHandler.addBike("FOLDING BIKE " + input, FILE_TEST3);
//        String expected = "FOLDING BIKE Formula with 21 gear(s) and no head/tail light.\n"
//                + "Price: 269.0 euros.\r\n";
//        String actual = getFromFile(FILE_TEST3);
//        actual = actual.substring(0, actual.length()/2);
//        Assert.assertEquals(expected, actual);
//        PrintWriter writer = new PrintWriter(FILE_TEST3);
//        writer.print("");
//        writer.close();
//    }
//
//    @Test
//    public void addNewSpeedElectricBikeIsOk() throws FileNotFoundException {
//        String input = "Booster; 35; 10900; false; 13200; green; 1279";
//        FileHandler.addBike("SPEEDELEC " + input, FILE_TEST3);
//        String expected = "SPEEDELECE Booster with 13200.0 mAh battery and  no head/tail light.\n" +
//                "Price: 1279.0 euros.\r\n";
//        String actual = getFromFile(FILE_TEST3);
//        actual = actual.substring(0, actual.length()/2);
//        Assert.assertEquals(expected, actual);
//        PrintWriter writer = new PrintWriter(FILE_TEST3);
//        writer.print("");
//        writer.close();
//    }
//
//    @Test
//    public void addNewElectricBikeIsOk() throws FileNotFoundException {
//        String input = "Lankeleisi; 50; 21600; false; 30000; flame; 859\n";
//        FileHandler.addBike("E-BIKE " + input, FILE_TEST3);
//        String expected = "E-BIKE Lankeleisi with 30000.0 mAh battery and  no head/tail light.\n" +
//                "Price: 859.0 euros.\r\n";
//        String actual = getFromFile(FILE_TEST3);
//        actual = actual.substring(0, actual.length()/2);
//        Assert.assertEquals(expected, actual);
//        PrintWriter writer = new PrintWriter(FILE_TEST3);
//        writer.print("");
//        writer.close();
//    }
//
//    @Test
//    public void getParticularBrand() {
//        String brand = "Booster";
//        boolean status = false;
//        FileHandler.readFromFile(FILE_TEST2);
//        for (Object bike : Storage.getBikes()) {
//            EcoBike ecoBike = (EcoBike) bike;
//            if (ecoBike.getBrand().equalsIgnoreCase(brand)) {
//                status = true;
//                break;
//            }
//        }
//        Assert.assertTrue(status);
//    }
//
}

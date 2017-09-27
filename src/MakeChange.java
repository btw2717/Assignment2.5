import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.Optional;
/**
 * The class MakeChange uses JavaFX to read a user input amount of dollars and cents,
 * parses the entry and stores it as a double,
 * converts it into exact change by the fewest possible items,
 * and outputs the entry as bills and coins.
 * This class is a JavaFX application so it utilizes a start() method instead of a main() method.
 * This class extends Application so it can use all the methods of the Application class.
 * This class names a number of constants in the class definition.
 * Created: 25SEP2015
 * email:
 * @author Sapper
 * @version 1.0
 *
 */
public class MakeChange extends Application {

    public static final int HUNDRED = 100;
    public static final int FIFTY = 50;
    public static final int TWENTY = 20;
    public static final int TEN = 10;
    public static final int FIVE = 5;
    public static final int ONE = 1;
    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;
    public static final int PENNY = 1;
    /**
     * The main() method is not used because class MakeChange is a JavaFX application.
     *
     * @param args The arguments passed to the application by command line.
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start() method is the entry point for the application and initializes a Stage object primary stage.
     * The start() method is a void method so it performs some action other than returning an item.
     * The start() method initializes all necessary primitive data type variables to store user entry
     * and perform calculations that determine the amount of each constant value required to make exact change.
     *
     * @param primaryStage object of the Stage class which is the top level container of JavaFX.
     */

    @Override
    public void start(Stage primaryStage) {

        int dollars = 0;
        int cents = 0;
        double originalCents = 0.0;
        double originalAmount = 0.0;
        double originalDollars = 0.0;

        Alert intro = new Alert(Alert.AlertType.INFORMATION);
        intro.setTitle("Introduction");
        intro.setHeaderText("Hello!");
        intro.setContentText("Hello there! My name is Linksys jr.\n" +
                "My father was a famous modem,\n" +
                "but I just convert dollars into change.");
        intro.showAndWait();

        TextInputDialog amount = new TextInputDialog("Dollar amount");
        amount.setTitle("Change maker");
        amount.setHeaderText("Let's make some change!");
        amount.setContentText("Please enter your dollar and change amount:");
        Optional<String> resultAmount = amount.showAndWait();
        originalAmount = Double.parseDouble(resultAmount.get());

        originalDollars = (int)originalAmount;
        dollars = (int)originalDollars;
        int hundreds = dollars / HUNDRED;
        dollars =  (dollars % HUNDRED);
        int fifties = (dollars / FIFTY);
        dollars = (dollars % FIFTY);
        int twenties = (dollars / TWENTY);
        dollars = (dollars % TWENTY);
        int tens = (dollars / TEN);
        dollars = (dollars % TEN);
        int fives = (dollars / FIVE);
        dollars = (dollars % FIVE);
        int ones = (dollars / ONE);


        originalCents =((originalAmount - (int)originalAmount) * 100) + 1;
        cents = (int)originalCents;
        int quarters = (cents / QUARTER);
        cents = (cents % QUARTER);
        int dimes = (cents / DIME);
        cents = (cents % DIME);
        int nickels = (cents / NICKEL);
        cents = (cents % NICKEL);
        int pennies = (cents / PENNY);

        Alert status = new Alert(Alert.AlertType.INFORMATION);
        status.setTitle("Status");
        status.setHeaderText("BEEP! BOOP!\nYou entered: " + originalAmount +
                "  I have converted it into exact change.");
        status.setContentText("Your amount in exact change is:\n" +
                hundreds + " hundreds\n" + fifties + " fifties\n" +
                twenties + " twenties\n" + tens + " tens\n" +
                fives + " fives\n" + ones + " ones\n" + " and:\n" +
                quarters + " quarters\n" + dimes + " dimes\n" +
                nickels + " nickels\n" + pennies + " pennies");
        
        status.showAndWait();

    }
}


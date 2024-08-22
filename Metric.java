import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Metric {
    String name = " ";
    String weightStatus = "";
    double weight = 0;
    double centi = 0;
    double meters = 0;
    double bmi = 0;

    public Metric(Scanner scan) {
        getDataM(scan);
        calculateM();
        display(scan);
    }

    public void getDataM(Scanner scan){

        System.out.print("Please enter you full name: ");
        name = scan.nextLine();

        System.out.print("Please enter height in centimeters for " + name + ": ");
        centi = scan.nextDouble();

        System.out.print("Please enter in weight in kilograms for " + name + ": ");
        weight = scan.nextDouble();

        meters = centi / 100;



    }
    public void
    calculateM(){

        bmi = weight / Math.pow(meters, 2);

        if(bmi <= 18.5){
            weightStatus = "Underweight";
        }
        else if(bmi <= 24.9){
            weightStatus = "Healthy Weight";
        }
        else if (bmi <= 29.9) {
            weightStatus = "Overweight";
        }
        else if (bmi <= 30){
            weightStatus = "Obesity";

            System.out.print(bmi);
        }

    }
    public void display(Scanner scan){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        String formattedDate = time.format(myFormatObj);
        DecimalFormat df = new DecimalFormat("0.0");
        double lowWeight = 0;
        double highWeight = 0;

        System.out.println("-- Summary Report for " + name);
        System.out.println("-- Date and Time: " + time);
        System.out.println("-- BMI: " + df.format(bmi));
        System.out.println("-- Weight Status: " + weightStatus );
        System.out.println(" ");

        System.out.print("Please enter a low weight in kilograms for " + name + ": ");
        lowWeight = scan.nextDouble();
        System.out.print("Please enter a high weight in kilograms for " + name + ": ");
        highWeight = scan.nextDouble();

        System.out.println("--".repeat(30));
        System.out.printf("| %-10s | %-8s| %-15s| %n", "Weight", "BMI", "Weight Status");
        System.out.println("--".repeat(30));


        double originalWeight = weight;


        weight = lowWeight;
        calculateM();
        System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus + "\u001B[43m(LOW)\u001B[0m");

        weight = weight + 2.5;

        while(weight <= highWeight){
            calculateM();

            if (weight > originalWeight && weight < originalWeight + 5.5) {
                double currentWeight = weight;
                weight = originalWeight;
                calculateM();
                System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus + " (this)");
                weight = currentWeight;
            }
            System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus);
            weight = weight + 2.5;

        }

        System.out.printf("| %-10s | %-8s| %-25s| %n", highWeight, df.format(bmi) , weightStatus + "\u001B[43m(HIGH)\u001B[0m");


        System.out.println("--".repeat(30));

    }
    public void ending() {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("-- Thank you for using my program %n" + name + "!");
        System.out.println("---------------------------------------------------------------------------------------");

    }



}
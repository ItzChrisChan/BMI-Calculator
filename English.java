import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class English {
    String name = " ";
    String weightStatus = " ";
    int height = 0;

    double weight = 0;
    double bmi = 0;

    public English(Scanner scanner) {
        getData(scanner);
        calculate();
        display(scanner);

    }

    public void getData(Scanner scan){

        System.out.print("Please enter you full name: ");
        name = scan.nextLine();

        System.out.print("Please enter height in feet and inches for " + name + ": ");

        scan = new Scanner(System.in);
        int feet = scan.nextInt();
        int inches = scan.nextInt();
        height = feet * 12 + inches;

        System.out.print("Please enter in weight in pounds for " + name + ": ");

        scan = new Scanner(System.in);
        weight = scan.nextInt();

        feet = feet * 12;
        inches = feet + inches;
    }

    public void calculate(){

        bmi = weight / Math.pow(height, 2) * 703;

        if(bmi <= 18.5){
            weightStatus = "Underweight";
        }
        else if(bmi <= 24.9){
            weightStatus = "Healthy Weight";
        }
        else if (bmi <= 29.9) {
            weightStatus = "Overweight";
        }
        else if (bmi >= 30){
            weightStatus = "Obesity";
        }

    }

    public void display(Scanner scan) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");

        String formattedDate = time.format(myFormatObj);
        DecimalFormat df = new DecimalFormat("0.0");
        double lowWeight = 0;
        double highWeight = 0;

        System.out.println("-- Summary Report for " + name);
        System.out.println("-- Date and Time: " + time);
        System.out.println("-- BMI: " + df.format(bmi));
        System.out.println("-- Weight Status: " + weightStatus );
        System.out.println(" ");

        System.out.print("Please enter a low weight in pounds for " + name + ": ");
        lowWeight = scan.nextDouble();
        System.out.print("Please enter a high weight in pounds for " + name + ": ");
        highWeight = scan.nextDouble();

        System.out.println("--".repeat(30));
        System.out.printf("| %-10s | %-8s| %-15s| %n", "Weight", "BMI", "Weight Status");
        System.out.println("--".repeat(30));

        double originalWeight = weight;
        weight = lowWeight;
        calculate();
        System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus + "\u001B[43m(LOW)\u001B[0m");

        weight = weight + 5.5;

        while(weight <= highWeight){
            calculate();

            if (weight > originalWeight && weight < originalWeight + 5.5) {
                double currentWeight = weight;
                weight = originalWeight;
                calculate();
                System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus + " (this)");
                weight = currentWeight;
            }
            System.out.printf("| %-10s | %-8s| %-25s| %n", weight, df.format(bmi) , weightStatus);
            weight = weight + 5.5;

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

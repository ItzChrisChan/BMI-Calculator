import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    public Menu() {
        getVersion();
        scan.close();
    }

    public void getVersion() {
        String input = "";

        int i = 0;
        while (i == 0) {

            System.out.println("My CSC 215 BMI Calculator Projects:");
            System.out.println("\t1.BMI, English");
            System.out.println("\t2.BMI, Metric");
            System.out.println("Enter an exclamation mark ! to end");
            System.out.print("Please enter the version you want to try: ");

            input = scan.nextLine();

            if (input.startsWith("E") || input.startsWith("e")) {
                welcome("English");
                English english = new English(scan);
            }
            else if (input.startsWith("M") || input.startsWith("m")) {
                welcome("Metric");
                Metric metric = new Metric(scan);
            }
            else if (input.equals("!")) {
                System.out.println("\nThank you using my BMI calculator.");
                i = 1;
            }


        }

    }
    public void welcome(String version){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("-- Welcome to: %n");
        System.out.printf("-- BODY MASS INDEX (BMI) Computation, CSC215, " + version + " version %n");
        System.out.println("--" + " ".repeat(40) + "By: Christopher Chan");
        System.out.println("---------------------------------------------------------------------------------------");

    }


}



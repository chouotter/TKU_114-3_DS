import java.util.Scanner;

public class HealthAdvisor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            System.out.print("請輸入姓名:");
            String name = sc.nextLine();

            System.out.print("請輸入身高:");
            double height = sc.nextDouble();

            System.out.print("請輸入體重:");
            double weight = sc.nextDouble();

            double bmi = weight / (height * height);

            String level;

            if (bmi < 18.5) {
                level = "Underweight";
            } else if (bmi < 24) {
                level = "Normal";
            } else if (bmi < 27) {
                level = "Overweight";
            } else {
                level = "Obese";
            }

            System.out.println();
            System.out.println("=== BMI Report ===");
            System.out.println("Name: " + name);
            System.out.println("BMI: " + bmi);
            System.out.println("Level: " + level);
            System.out.println();

            sc.nextLine(); 

            System.out.print("是否繼續輸入下一筆？(y/n):");
            choice = sc.nextLine();
        }

        System.out.println("程式結束！");
        sc.close();
    }
}
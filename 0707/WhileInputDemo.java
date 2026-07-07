import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number;

        System.out.print("請輸入整數:");
        number = sc.nextInt();

        while (number != 0) {
            System.out.println(number);
            number = sc.nextInt();
        }

        System.out.println("程式結束");

        sc.close();
    }
}
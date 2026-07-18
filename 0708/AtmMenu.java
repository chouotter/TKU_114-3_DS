import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 1000;
        int choice;
        int amount;

        while (true) {

            System.out.println("===== ATM Menu =====");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;

                case 2:
                    while (true) {
                        System.out.print("請輸入存款金額：");
                        amount = sc.nextInt();

                        if (amount > 0) {
                            balance += amount;
                            System.out.println("存款成功");
                            System.out.println("目前餘額：" + balance);
                            break;
                        } else {
                            System.out.println("存款金額必須大於 0！");
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.print("請輸入提款金額：");
                        amount = sc.nextInt();

                        if (amount <= 0) {
                            System.out.println("提款金額必須大於 0！");
                        } else if (amount > balance) {
                            System.out.println("餘額不足");
                        } else {
                            balance -= amount;
                            System.out.println("提款成功");
                            System.out.println("目前餘額：" + balance);
                            break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("謝謝使用 ATM");
                    sc.close();
                    return;

                default:
                    System.out.println("無效的選項");
            }

            System.out.println();
        }
    }
}
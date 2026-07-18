import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        int price = 0;

        int totalQuantity = 0;
        int totalAmount = 0;

        while (true) {

            System.out.println("===== Drink Menu =====");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請選擇商品：");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    price = 30;
                    break;

                case 2:
                    price = 35;
                    break;

                case 3:
                    price = 50;
                    break;

                case 0:
                    System.out.println("===== 結帳 =====");
                    System.out.println("總數量：" + totalQuantity);
                    System.out.println("總金額：" + totalAmount);
                    sc.close();
                    return;

                default:
                    System.out.println("商品不存在！");
                    continue;
            }

            while (true) {
                System.out.print("請輸入數量：");
                quantity = sc.nextInt();

                if (quantity > 0) {
                    break;
                } else {
                    System.out.println("數量必須大於0！");
                }
            }

            int subtotal = price * quantity;

            totalQuantity += quantity;
            totalAmount += subtotal;

            System.out.println("本次小計：" + subtotal);
            System.out.println();
        }
    }
}
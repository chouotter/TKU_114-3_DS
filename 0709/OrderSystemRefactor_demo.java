import java.util.Scanner;

public class OrderSystemRefactor_demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        int price;

        int totalQuantity = 0;
        int totalAmount = 0;

        while (true) {

            printMenu();

            choice = sc.nextInt();

            if (choice == 0) {
                printReceipt(totalQuantity, totalAmount);
                sc.close();
                return;
            }

            price = getPrice(choice);

            if (price == 0) {
                System.out.println("商品不存在！");
                System.out.println();
                continue;
            }

            quantity = readValidQuantity(sc);

            int subtotal = calculateSubtotal(price, quantity);

            totalQuantity += quantity;
            totalAmount += subtotal;

            System.out.println("本次小計：" + subtotal);
            System.out.println();
        }
    }


    public static void printMenu() {
        System.out.println("===== Drink Menu =====");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Coffee     $50");
        System.out.println("0. Checkout");
        System.out.print("請選擇商品：");
    }

  
    public static int getPrice(int option) {

        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 50;
            default:
                return 0;
        }

    }


    public static int readValidQuantity(Scanner sc) {

        int quantity;

        while (true) {

            System.out.print("請輸入數量：");
            quantity = sc.nextInt();

            if (quantity > 0) {
                return quantity;
            } else {
                System.out.println("數量必須大於0！");
            }

        }

    }

 
    public static int calculateSubtotal(int price, int quantity) {

        return price * quantity;

    }

 
    public static void printReceipt(int totalItems, int totalAmount) {

        System.out.println("===== 結帳 =====");
        System.out.println("總數量：" + totalItems);
        System.out.println("總金額：" + totalAmount);

    }

}
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            printMenu();

            while (!sc.hasNextInt()) {
                System.out.println("請輸入數字！");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addItem();
                    break;

                case 2:
                    updateQuantity();
                    break;

                case 3:
                    removeItem();
                    break;

                case 4:
                    showCart();
                    break;

                case 5:
                    calculateTotal();
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("無效選項！");
            }

        } while (choice != 0);

    }

    // Method 1
    public static void printMenu() {

        System.out.println("\n===== 購物車系統 =====");
        System.out.println("1. 加入商品");
        System.out.println("2. 修改數量");
        System.out.println("3. 移除商品");
        System.out.println("4. 顯示購物車");
        System.out.println("5. 計算總額");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

    // Method 2
    public static CartItem findItem(String id) {

        for (CartItem item : cart) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }

    // Method 3
    public static void addItem() {

        System.out.print("商品代碼：");
        String id = sc.nextLine();

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        System.out.print("單價：");
        double price = sc.nextDouble();

        System.out.print("數量：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("數量必須大於0！");
            return;
        }

        CartItem item = findItem(id);

        if (item != null) {

            item.addQuantity(quantity);
            System.out.println("商品已存在，數量已增加！");

        } else {

            cart.add(new CartItem(id, name, price, quantity));
            System.out.println("商品加入成功！");

        }

    }

    // Method 4
    public static void updateQuantity() {

        System.out.print("輸入商品代碼：");
        String id = sc.nextLine();

        CartItem item = findItem(id);

        if (item == null) {
            System.out.println("找不到商品！");
            return;
        }

        System.out.print("輸入新數量：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("數量必須大於0！");
            return;
        }

        item.setQuantity(quantity);

        System.out.println("修改成功！");
    }

    // Method 5
    public static void removeItem() {

        System.out.print("輸入商品代碼：");
        String id = sc.nextLine();

        CartItem item = findItem(id);

        if (item == null) {
            System.out.println("找不到商品！");
            return;
        }

        cart.remove(item);

        System.out.println("商品已移除！");
    }

    // Method 6
    public static void showCart() {

        if (cart.isEmpty()) {
            System.out.println("購物車是空的！");
            return;
        }

        System.out.println("\n===== 購物車 =====");

        for (CartItem item : cart) {
            System.out.println("---------------------");
            System.out.println(item);
        }

    }

    // Method 7
    public static void calculateTotal() {

        double total = 0;

        for (CartItem item : cart) {
            total += item.getSubtotal();
        }

        System.out.printf("購物車總額：%.2f 元%n", total);

    }

}
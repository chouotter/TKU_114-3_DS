import java.util.Scanner;

public class ProductManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static Product[] products = new Product[10];

    static int addCount = 0;
    static int sellCount = 0;
    static int restockCount = 0;
    static int updatePriceCount = 0;

    public static void main(String[] args) {

        initializeProducts();

        int choice;

        do {

            printMenu();
            System.out.print("請輸入選項：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    showAllProducts();
                    break;

                case 2:
                    searchProduct();
                    break;

                case 3:
                    addProduct();
                    break;

                case 4:
                    sellProduct();
                    break;

                case 5:
                    restockProduct();
                    break;

                case 6:
                    updatePrice();
                    break;

                case 7:
                    showLowStock();
                    break;

                case 8:
                    showInventoryValue();
                    break;

                case 0:
                    showSummary();
                    break;

                default:
                    System.out.println("選項錯誤！");
            }

        } while (choice != 0);

    }

    //====================================================

    public static void initializeProducts() {

        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("USB Cable", 250, 30);
        products[4] = new Product("Headset", 1290, 8);

    }

    public static void printMenu() {

        System.out.println("\n===== 商品管理系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 搜尋商品");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改價格");
        System.out.println("7. 顯示低庫存商品");
        System.out.println("8. 顯示全部庫存總價值");
        System.out.println("0. 結束");

    }

    public static void showAllProducts() {

        System.out.println("\n===== 商品列表 =====");

        for (Product p : products) {

            if (p != null) {

                System.out.println(p);

            }

        }

    }

    public static int findProduct(String name) {

        name = name.trim();

        for (int i = 0; i < products.length; i++) {

            if (products[i] != null &&
                    products[i].getName().equalsIgnoreCase(name)) {

                return i;

            }

        }

        return -1;

    }

    public static void searchProduct() {

        System.out.print("輸入商品名稱：");
        String name = sc.nextLine();

        int index = findProduct(name);

        if (index == -1) {

            System.out.println("找不到商品");

        } else {

            System.out.println(products[index]);

        }

    }

    public static void addProduct() {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        if (findProduct(name) != -1) {

            System.out.println("商品已存在！");
            return;

        }

        int empty = -1;

        for (int i = 0; i < products.length; i++) {

            if (products[i] == null) {

                empty = i;
                break;

            }

        }

        if (empty == -1) {

            System.out.println("商品陣列已滿！");
            return;

        }

        System.out.print("價格：");
        int price = sc.nextInt();

        System.out.print("庫存：");
        int stock = sc.nextInt();
        sc.nextLine();

        products[empty] = new Product(name, price, stock);

        addCount++;

        System.out.println("新增成功！");

    }

    public static void sellProduct() {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        int index = findProduct(name);

        if (index == -1) {

            System.out.println("找不到商品");
            return;

        }

        System.out.print("出售數量：");
        int amount = sc.nextInt();
        sc.nextLine();

        if (products[index].sell(amount)) {

            sellCount++;
            System.out.println("出售成功");

        } else {

            System.out.println("出售失敗");

        }

    }

    public static void restockProduct() {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        int index = findProduct(name);

        if (index == -1) {

            System.out.println("找不到商品");
            return;

        }

        System.out.print("補貨數量：");
        int amount = sc.nextInt();
        sc.nextLine();

        if (products[index].restock(amount)) {

            restockCount++;
            System.out.println("補貨成功");

        } else {

            System.out.println("補貨失敗");

        }

    }

    public static void updatePrice() {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        int index = findProduct(name);

        if (index == -1) {

            System.out.println("找不到商品");
            return;

        }

        System.out.print("新價格：");
        int price = sc.nextInt();
        sc.nextLine();

        if (products[index].setPrice(price)) {

            updatePriceCount++;
            System.out.println("修改成功");

        } else {

            System.out.println("修改失敗");

        }

    }

    public static void showLowStock() {

        System.out.println("\n===== 低庫存商品 =====");

        for (Product p : products) {

            if (p != null && p.isLowStock()) {

                System.out.println(p);

            }

        }

    }

    public static void showInventoryValue() {

        int total = 0;

        for (Product p : products) {

            if (p != null) {

                total += p.getInventoryValue();

            }

        }

        System.out.println("全部庫存總價值：" + total);

    }

    public static void showSummary() {

        System.out.println("\n===== 操作摘要 =====");

        System.out.println("新增商品：" + addCount);
        System.out.println("出售商品：" + sellCount);
        System.out.println("補貨次數：" + restockCount);
        System.out.println("修改價格：" + updatePriceCount);

        System.out.println("謝謝使用！");

    }

}
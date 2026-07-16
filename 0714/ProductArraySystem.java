import java.util.Scanner;

public class ProductArraySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int buyCount = 0;
        int restockCount = 0;

        while (true) {

            printMenu();

            System.out.print("請輸入選項：");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayProducts(names, prices, stocks);
                    break;

                case 2:
                    queryProduct(sc, names, prices, stocks);
                    break;

                case 3:
                    if (buyProduct(sc, names, prices, stocks)) {
                        buyCount++;
                    }
                    break;

                case 4:
                    if (restockProduct(sc, names, stocks)) {
                        restockCount++;
                    }
                    break;

                case 5:
                    displayLowStock(names, stocks);
                    break;

                case 6:
                    displayTotalValue(prices, stocks);
                    break;

                case 0:
                    printSummary(buyCount, restockCount);
                    System.out.println("系統結束！");
                    sc.close();
                    return;

                default:
                    System.out.println("選項錯誤！");
            }

            System.out.println();
        }

    }


    public static void printMenu() {

        System.out.println("========== 商品管理系統 ==========");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充商品庫存");
        System.out.println("5. 顯示低庫存商品");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("0. 離開");
    }

    public static void displayProducts(String[] names, int[] prices, int[] stocks) {

        System.out.println("編號\t商品\t\t價格\t庫存");

        for (int i = 0; i < names.length; i++) {

            System.out.println((i + 1) + "\t"
                    + names[i] + "\t"
                    + prices[i] + "\t"
                    + stocks[i]);
        }

    }


    public static void queryProduct(Scanner sc,
                                    String[] names,
                                    int[] prices,
                                    int[] stocks) {

        System.out.print("請輸入商品編號：");
        int id = sc.nextInt();

        if (id < 1 || id > names.length) {
            System.out.println("商品不存在！");
            return;
        }

        int index = id - 1;

        System.out.println("商品名稱：" + names[index]);
        System.out.println("價格：" + prices[index]);
        System.out.println("庫存：" + stocks[index]);

    }


    public static boolean buyProduct(Scanner sc,
                                     String[] names,
                                     int[] prices,
                                     int[] stocks) {

        System.out.print("商品編號：");
        int id = sc.nextInt();

        if (id < 1 || id > names.length) {
            System.out.println("商品不存在！");
            return false;
        }

        int index = id - 1;

        System.out.print("購買數量：");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("數量必須大於0！");
            return false;
        }

        if (amount > stocks[index]) {
            System.out.println("庫存不足！");
            return false;
        }

        stocks[index] -= amount;

        System.out.println("購買成功！");
        System.out.println("商品：" + names[index]);
        System.out.println("總金額：" + prices[index] * amount);
        System.out.println("剩餘庫存：" + stocks[index]);

        return true;

    }


    public static boolean restockProduct(Scanner sc,
                                         String[] names,
                                         int[] stocks) {

        System.out.print("商品編號：");
        int id = sc.nextInt();

        if (id < 1 || id > names.length) {
            System.out.println("商品不存在！");
            return false;
        }

        int index = id - 1;

        System.out.print("補貨數量：");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("補貨數量必須大於0！");
            return false;
        }

        stocks[index] += amount;

        System.out.println("補貨成功！");
        System.out.println("目前庫存：" + stocks[index]);

        return true;

    }


    public static void displayLowStock(String[] names, int[] stocks) {

        System.out.println("=== 低庫存商品 ===");

        boolean found = false;

        for (int i = 0; i < stocks.length; i++) {

            if (stocks[i] < 10) {

                System.out.println((i + 1) + ". "
                        + names[i]
                        + " 庫存：" + stocks[i]);

                found = true;
            }

        }

        if (!found) {
            System.out.println("沒有低庫存商品。");
        }

    }


    public static void displayTotalValue(int[] prices,
                                         int[] stocks) {

        int total = 0;

        for (int i = 0; i < prices.length; i++) {

            total += prices[i] * stocks[i];

        }

        System.out.println("全部庫存總價值：" + total + " 元");

    }


    public static void printSummary(int buyCount,
                                    int restockCount) {

        System.out.println("========== 操作摘要 ==========");
        System.out.println("購買次數：" + buyCount);
        System.out.println("補貨次數：" + restockCount);

    }

}
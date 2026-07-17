import java.util.Scanner;

public class ProductDataManager {

    static String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
    };

    static String[] names = new String[records.length];
    static int[] prices = new int[records.length];
    static int[] stocks = new int[records.length];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        parseRecords();

        int choice;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    showProducts();
                    break;

                case 2:
                    System.out.print("請輸入完整商品名稱：");
                    fullSearch(sc.nextLine());
                    break;

                case 3:
                    System.out.print("請輸入部分商品名稱：");
                    partialSearch(sc.nextLine());
                    break;

                case 4:
                    showLowStock();
                    break;

                case 5:
                    showTotalValue();
                    break;

                case 6:
                    System.out.print("請輸入新商品資料(name,price,stock)：");
                    addRecord(sc.nextLine());
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("選項錯誤！");
            }

        } while (choice != 0);

        sc.close();

    }


    public static void parseRecords() {

        for (int i = 0; i < records.length; i++) {

            String[] data = records[i].split(",");

            names[i] = data[0];
            prices[i] = Integer.parseInt(data[1]);
            stocks[i] = Integer.parseInt(data[2]);

        }

    }


    public static void printMenu() {

        System.out.println("\n====== 商品文字資料管理器 ======");
        System.out.println("1. 顯示商品");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示低庫存商品");
        System.out.println("5. 顯示庫存總價值");
        System.out.println("6. 驗證新商品資料");
        System.out.println("0. 結束");

    }


    public static void showProducts() {

        System.out.println("\n商品列表");

        for (int i = 0; i < names.length; i++) {

            System.out.printf("%-12s 價格:%5d 庫存:%3d%n",
                    names[i], prices[i], stocks[i]);

        }

    }


    public static void fullSearch(String keyword) {

        keyword = keyword.trim();

        boolean found = false;

        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(keyword)) {

                System.out.println(names[i]
                        + " 價格：" + prices[i]
                        + " 庫存：" + stocks[i]);

                found = true;

            }

        }

        if (!found) {

            System.out.println("查無商品");

        }

    }


    public static void partialSearch(String keyword) {

        keyword = keyword.toLowerCase();

        boolean found = false;

        for (int i = 0; i < names.length; i++) {

            if (names[i].toLowerCase().contains(keyword)) {

                System.out.println(names[i]
                        + " 價格：" + prices[i]
                        + " 庫存：" + stocks[i]);

                found = true;

            }

        }

        if (!found) {

            System.out.println("查無商品");

        }

    }


    public static void showLowStock() {

        System.out.println("\n低庫存商品");

        for (int i = 0; i < names.length; i++) {

            if (stocks[i] < 10) {

                System.out.println(names[i]
                        + " 庫存：" + stocks[i]);

            }

        }

    }


    public static void showTotalValue() {

        int total = 0;

        for (int i = 0; i < names.length; i++) {

            total += prices[i] * stocks[i];

        }

        System.out.println("庫存總價值：" + total);

    }

 
    public static void addRecord(String record) {

        String[] data = record.split(",");

        if (data.length != 3) {

            System.out.println("格式錯誤：必須為 名稱,價格,庫存");

            return;

        }

        try {

            String name = data[0];

            int price = Integer.parseInt(data[1]);

            int stock = Integer.parseInt(data[2]);

            System.out.println("資料正確");

            System.out.println("名稱：" + name);
            System.out.println("價格：" + price);
            System.out.println("庫存：" + stock);

        }

        catch (NumberFormatException e) {

            System.out.println("數字格式錯誤：" + e.getMessage());

        }

    }

}

/*
===========================
測試案例
===========================

1.
功能：顯示商品
結果：
五筆商品全部正常顯示

2.
功能：完整搜尋
輸入：
Keyboard
結果：
找到 Keyboard

3.
功能：完整搜尋
輸入：
keyboard
結果：
找到 Keyboard（忽略大小寫）

4.
功能：部分搜尋
輸入：
usb
結果：
USB Cable

5.
功能：部分搜尋
輸入：
o
結果：
Mouse
Monitor

6.
功能：低庫存
結果：
Monitor
Headset

7.
功能：新增資料
輸入：
Camera,3500,6
結果：
資料正確

8.
功能：新增資料
輸入：
Camera,abc,6
結果：
數字格式錯誤

9.
功能：新增資料
輸入：
Camera,3500
結果：
格式錯誤

*/
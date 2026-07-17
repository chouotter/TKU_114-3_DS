import java.util.Scanner;

public class ProductSearchSystem {

    static String[] names = {
            "Keyboard",
            "Mouse",
            "Monitor",
            "USB Cable",
            "Headset"
    };

    static int[] prices = {
            890,
            490,
            5200,
            250,
            1290
    };

    static int[] stocks = {
            12,
            20,
            5,
            30,
            8
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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
                    String full = sc.nextLine();
                    fullSearch(full);
                    break;

                case 3:
                    System.out.print("請輸入部分名稱：");
                    String part = sc.nextLine();
                    partialSearch(part);
                    break;

                case 4:
                    showLongestName();
                    break;

                case 5:
                    System.out.print("請輸入搜尋關鍵字：");
                    String keyword = sc.nextLine();
                    showFirstPosition(keyword);
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

 
    public static void printMenu() {

        System.out.println("\n===== 商品名稱搜尋系統 =====");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示名稱最長商品");
        System.out.println("5. 顯示第一次出現位置");
        System.out.println("0. 結束");

    }


    public static void showProducts() {

        System.out.println("\n商品列表");

        for (int i = 0; i < names.length; i++) {

            System.out.println(
                    (i + 1) + ". "
                            + names[i]
                            + "　價格：" + prices[i]
                            + "　庫存：" + stocks[i]);

        }

    }

 
    public static void fullSearch(String keyword) {

        keyword = keyword.trim();

        boolean found = false;

        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(keyword)) {

                System.out.println("找到商品：");
                System.out.println(names[i]);
                System.out.println("價格：" + prices[i]);
                System.out.println("庫存：" + stocks[i]);

                found = true;
                break;

            }

        }

        if (!found) {
            System.out.println("查無此商品！");
        }

    }


    public static void partialSearch(String keyword) {

        keyword = keyword.trim().toLowerCase();

        boolean found = false;

        System.out.println("搜尋結果：");

        for (int i = 0; i < names.length; i++) {

            if (names[i].toLowerCase().contains(keyword)) {

                System.out.println(
                        names[i]
                                + "　價格：" + prices[i]
                                + "　庫存：" + stocks[i]);

                found = true;

            }

        }

        if (!found) {

            System.out.println("查無符合商品！");

        }

    }


    public static void showLongestName() {

        String longest = names[0];

        for (int i = 1; i < names.length; i++) {

            if (names[i].length() > longest.length()) {

                longest = names[i];

            }

        }

        System.out.println("名稱最長商品：" + longest);

    }


    public static void showFirstPosition(String keyword) {

        keyword = keyword.toLowerCase();

        boolean found = false;

        for (String name : names) {

            int index = name.toLowerCase().indexOf(keyword);

            if (index != -1) {

                System.out.println(name + " 第一次出現在位置：" + index);
                found = true;

            }

        }

        if (!found) {

            System.out.println("所有商品皆找不到此關鍵字。");

        }

    }

}

/*
=========================
測試案例
=========================

1.
功能：完整搜尋
輸入：
keyboard
結果：
找到 Keyboard

2.
功能：完整搜尋
輸入：
 Keyboard
結果：
找到 Keyboard(忽略前後空白)

3.
功能：完整搜尋
輸入：
APPLE
結果：
查無此商品

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
功能：第一次出現位置
輸入：
o
結果：
Mouse -> 1
Monitor -> 1

*/

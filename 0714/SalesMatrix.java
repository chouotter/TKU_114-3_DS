import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

 
        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        System.out.println("\n===== 銷售矩陣 =====");
        printSales(sales);

        System.out.println("\n===== 每項商品總銷售量 =====");
        printProductTotal(sales);

        System.out.println("\n===== 每天總銷售量 =====");
        printDayTotal(sales);

        System.out.println();
        printBestProduct(sales);

        sc.close();
    }


    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {

                while (true) {
                    System.out.print("請輸入商品 " + (i + 1) + " 第 " + (j + 1) + " 天的銷售量：");
                    int value = sc.nextInt();

                    if (value >= 0) {
                        sales[i][j] = value;
                        break;
                    } else {
                        System.out.println("銷售量不可小於 0，請重新輸入！");
                    }
                }

            }
        }
    }


    public static void printSales(int[][] sales) {

        System.out.print("商品\\天");
        for (int day = 1; day <= sales[0].length; day++) {
            System.out.print("\tDay" + day);
        }
        System.out.println();

        for (int i = 0; i < sales.length; i++) {
            System.out.print("商品" + (i + 1));

            for (int j = 0; j < sales[i].length; j++) {
                System.out.print("\t" + sales[i][j]);
            }

            System.out.println();
        }
    }


    public static void printProductTotal(int[][] sales) {

        for (int i = 0; i < sales.length; i++) {
            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            System.out.println("商品 " + (i + 1) + " 總銷售量：" + total);
        }
    }


    public static void printDayTotal(int[][] sales) {

        for (int j = 0; j < sales[0].length; j++) {

            int total = 0;

            for (int i = 0; i < sales.length; i++) {
                total += sales[i][j];
            }

            System.out.println("第 " + (j + 1) + " 天總銷售量：" + total);
        }
    }


    public static void printBestProduct(int[][] sales) {

        int maxTotal = 0;
        int bestProduct = 0;

        for (int i = 0; i < sales.length; i++) {

            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            if (i == 0 || total > maxTotal) {
                maxTotal = total;
                bestProduct = i;
            }
        }

        System.out.println("總銷售量最高的商品：商品 " + (bestProduct + 1));
        System.out.println("總銷售量：" + maxTotal);
    }
}
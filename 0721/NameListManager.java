import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int choice;

        do {
            printMenu();

            while (!sc.hasNextInt()) {
                System.out.println("請輸入正確的選項！");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addName(sc, names);
                    break;
                case 2:
                    searchName(sc, names);
                    break;
                case 3:
                    updateName(sc, names);
                    break;
                case 4:
                    deleteName(sc, names);
                    break;
                case 5:
                    listNames(names);
                    break;
                case 0:
                    System.out.println("程式結束！");
                    break;
                default:
                    System.out.println("無效的選項！");
            }

        } while (choice != 0);

        sc.close();
    }


    public static void printMenu() {
        System.out.println("\n===== 名單管理系統 =====");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }


    public static void addName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        names.add(name);
        System.out.println("新增成功！");
    }


    public static void searchName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要搜尋的姓名：");
        String target = sc.nextLine().trim();

        int index = findIndex(names, target);

        if (index != -1) {
            System.out.println("找到：" + names.get(index));
        } else {
            System.out.println("找不到此姓名！");
        }
    }


    public static void updateName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要修改的姓名：");
        String oldName = sc.nextLine().trim();

        int index = findIndex(names, oldName);

        if (index == -1) {
            System.out.println("找不到此姓名！");
            return;
        }

        System.out.print("請輸入新的姓名：");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        names.set(index, newName);
        System.out.println("修改成功！");
    }


    public static void deleteName(Scanner sc, ArrayList<String> names) {
        System.out.print("請輸入要刪除的姓名：");
        String target = sc.nextLine().trim();

        int index = findIndex(names, target);

        if (index != -1) {
            names.remove(index);
            System.out.println("刪除成功！");
        } else {
            System.out.println("找不到此姓名！");
        }
    }


    public static void listNames(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("目前沒有任何姓名。");
            return;
        }

        System.out.println("\n===== 名單 =====");

        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }


    public static int findIndex(ArrayList<String> names, String target) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
}
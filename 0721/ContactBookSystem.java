import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

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
                    addContact();
                    break;

                case 2:
                    searchContact();
                    break;

                case 3:
                    updatePhone();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    listContacts();
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
        System.out.println("\n===== 聯絡人管理系統 =====");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人");
        System.out.println("3. 修改電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 顯示全部聯絡人");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

    // Method 2
    public static void addContact() {

        System.out.print("輸入代碼：");
        String id = sc.nextLine();

        if (findContact(id) != null) {
            System.out.println("代碼已存在！");
            return;
        }

        System.out.print("輸入姓名：");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        System.out.print("輸入電話：");
        String phone = sc.nextLine();

        System.out.print("輸入Email：");
        String email = sc.nextLine();

        contacts.add(new Contact(id, name, phone, email));

        System.out.println("新增成功！");
    }

    // Method 3
    public static Contact findContact(String id) {

        for (Contact c : contacts) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    // Method 4
    public static void searchContact() {

        System.out.print("輸入代碼：");
        String id = sc.nextLine();

        Contact c = findContact(id);

        if (c == null) {
            System.out.println("找不到聯絡人！");
        } else {
            System.out.println(c);
        }

    }

    // Method 5
    public static void updatePhone() {

        System.out.print("輸入代碼：");
        String id = sc.nextLine();

        Contact c = findContact(id);

        if (c == null) {
            System.out.println("找不到聯絡人！");
            return;
        }

        System.out.print("輸入新電話：");
        String phone = sc.nextLine();

        c.setPhone(phone);

        System.out.println("修改成功！");
    }

    // Method 6
    public static void deleteContact() {

        System.out.print("輸入代碼：");
        String id = sc.nextLine();

        Contact c = findContact(id);

        if (c == null) {
            System.out.println("找不到聯絡人！");
            return;
        }

        contacts.remove(c);

        System.out.println("刪除成功！");
    }

    // Method 7
    public static void listContacts() {

        if (contacts.isEmpty()) {
            System.out.println("目前沒有聯絡人！");
            return;
        }

        System.out.println("\n===== 聯絡人清單 =====");

        for (Contact c : contacts) {
            System.out.println("----------------");
            System.out.println(c);
        }

    }

}
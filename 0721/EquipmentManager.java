import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> equipments = new ArrayList<>();

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
                    addEquipment(sc, equipments);
                    break;

                case 2:
                    searchEquipment(sc, equipments);
                    break;

                case 3:
                    borrowEquipment(sc, equipments);
                    break;

                case 4:
                    returnEquipment(sc, equipments);
                    break;

                case 5:
                    listAvailable(equipments);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("無效選項！");
            }

        } while (choice != 0);

        sc.close();
    }

 
    public static void printMenu() {
        System.out.println("\n===== 設備管理 =====");
        System.out.println("1. 新增設備");
        System.out.println("2. 依代碼搜尋");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出可借設備");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

 
    public static void addEquipment(Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("設備代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }

        if (findEquipment(equipments, code) != null) {
            System.out.println("代碼不可重複！");
            return;
        }

        System.out.print("設備名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("名稱不可空白！");
            return;
        }

        equipments.add(new Equipment(code, name));
        System.out.println("新增成功！");
    }

  
    public static void searchEquipment(Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine().trim();

        Equipment e = findEquipment(equipments, code);

        if (e == null) {
            System.out.println("找不到設備！");
        } else {
            System.out.println(e);
        }
    }

 
    public static void borrowEquipment(Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine().trim();

        Equipment e = findEquipment(equipments, code);

        if (e == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (e.borrow()) {
            System.out.println("借出成功！");
        } else {
            System.out.println("設備已借出！");
        }
    }


    public static void returnEquipment(Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備代碼：");
        String code = sc.nextLine().trim();

        Equipment e = findEquipment(equipments, code);

        if (e == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (e.giveBack()) {
            System.out.println("歸還成功！");
        } else {
            System.out.println("設備本來就是可借用！");
        }
    }

  
    public static void listAvailable(ArrayList<Equipment> equipments) {

        if (equipments.isEmpty()) {
            System.out.println("目前沒有設備！");
            return;
        }

        System.out.println("\n代碼\t名稱\t狀態");

        boolean found = false;

        for (Equipment e : equipments) {

            if (e.isAvailable()) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("目前沒有可借設備！");
        }
    }


    public static Equipment findEquipment(
            ArrayList<Equipment> equipments,
            String code) {

        for (Equipment e : equipments) {

            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }

        return null;
    }
}
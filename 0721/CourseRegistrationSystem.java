import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Course> courses = new ArrayList<>();

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
                    addCourse();
                    break;

                case 2:
                    registerCourse();
                    break;

                case 3:
                    dropCourse();
                    break;

                case 4:
                    deleteCourse();
                    break;

                case 5:
                    searchCourse();
                    break;

                case 6:
                    showStatistics();
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

        System.out.println("\n===== 選課管理系統 =====");
        System.out.println("1. 新增課程");
        System.out.println("2. 選課");
        System.out.println("3. 退選");
        System.out.println("4. 刪除課程");
        System.out.println("5. 搜尋課程");
        System.out.println("6. 統計資料");
        System.out.println("0. 離開");
        System.out.print("請選擇：");

    }

    // Method 2
    public static Course findCourse(String id) {

        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    // Method 3
    public static void addCourse() {

        System.out.print("課程代碼：");
        String id = sc.nextLine();

        if (findCourse(id) != null) {
            System.out.println("課程代碼不可重複！");
            return;
        }

        System.out.print("課程名稱：");
        String name = sc.nextLine();

        System.out.print("課程容量：");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity <= 0) {
            System.out.println("容量必須大於0！");
            return;
        }

        courses.add(new Course(id, name, capacity));

        System.out.println("新增成功！");

    }

    // Method 4
    public static void registerCourse() {

        System.out.print("輸入課程代碼：");
        String id = sc.nextLine();

        Course c = findCourse(id);

        if (c == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (c.register()) {
            System.out.println("選課成功！");
        } else {
            System.out.println("課程已額滿！");
        }

    }

    // Method 5
    public static void dropCourse() {

        System.out.print("輸入課程代碼：");
        String id = sc.nextLine();

        Course c = findCourse(id);

        if (c == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (c.drop()) {
            System.out.println("退選成功！");
        } else {
            System.out.println("目前無學生可退選！");
        }

    }

    // Method 6
    public static void deleteCourse() {

        System.out.print("輸入課程代碼：");
        String id = sc.nextLine();

        Course c = findCourse(id);

        if (c == null) {
            System.out.println("找不到課程！");
            return;
        }

        courses.remove(c);

        System.out.println("刪除成功！");

    }

    // Method 7
    public static void searchCourse() {

        System.out.print("輸入課程代碼：");
        String id = sc.nextLine();

        Course c = findCourse(id);

        if (c == null) {
            System.out.println("找不到課程！");
        } else {
            System.out.println(c);
        }

    }

    // Method 8
    public static void showStatistics() {

        System.out.println("\n===== 統計資料 =====");

        System.out.println("總課程數：" + courses.size());

        int totalStudents = 0;

        for (Course c : courses) {
            totalStudents += c.getStudents();
        }

        System.out.println("總選課人次：" + totalStudents);

        System.out.println("\n額滿課程：");

        boolean found = false;

        for (Course c : courses) {

            if (c.isFull()) {
                System.out.println("----------------");
                System.out.println(c);
                found = true;
            }

        }

        if (!found) {
            System.out.println("目前沒有額滿課程。");
        }

    }

}
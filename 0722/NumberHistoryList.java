import java.util.LinkedList;

public class NumberHistoryList {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.println("===== 數字紀錄串列測試 =====");

        // 1
        addFirst(numbers, 30);

        // 2
        addLast(numbers, 50);

        // 3
        addFirst(numbers, 10);

        // 4
        addLast(numbers, 80);

        // 5
        printList(numbers);

        // 6
        searchNumber(numbers, 50);

        // 7
        searchNumber(numbers, 100);

        // 8
        removeNumber(numbers, 30);

        // 9
        removeNumber(numbers, 999);

        // 10
        printList(numbers);

        // 11
        printStatistics(numbers);

        // 清空串列
        numbers.clear();

        System.out.println("\n清空串列後：");
        printList(numbers);
        printStatistics(numbers);
    }

    // 前端新增
    public static void addFirst(LinkedList<Integer> list, int value) {
        list.addFirst(value);
        System.out.println("前端新增：" + value);
    }

    // 尾端新增
    public static void addLast(LinkedList<Integer> list, int value) {
        list.addLast(value);
        System.out.println("尾端新增：" + value);
    }

    // 搜尋
    public static void searchNumber(LinkedList<Integer> list, int value) {
        if (list.contains(value)) {
            System.out.println(value + " 找到，索引：" + list.indexOf(value));
        } else {
            System.out.println(value + " 不存在");
        }
    }

    // 刪除
    public static void removeNumber(LinkedList<Integer> list, int value) {
        if (list.remove(Integer.valueOf(value))) {
            System.out.println("成功刪除：" + value);
        } else {
            System.out.println("找不到要刪除的資料：" + value);
        }
    }

    // 顯示串列
    public static void printList(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("串列目前為空");
        } else {
            System.out.println("目前串列：" + list);
        }
    }

    // 統計
    public static void printStatistics(LinkedList<Integer> list) {

        if (list.isEmpty()) {
            System.out.println("===== 統計結果 =====");
            System.out.println("Size：0");
            System.out.println("總和：0");
            System.out.println("最大值：無");
            System.out.println("最小值：無");
            return;
        }

        int sum = 0;
        int max = list.getFirst();
        int min = list.getFirst();

        for (int num : list) {
            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        System.out.println("===== 統計結果 =====");
        System.out.println("Size：" + list.size());
        System.out.println("總和：" + sum);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
    }
}
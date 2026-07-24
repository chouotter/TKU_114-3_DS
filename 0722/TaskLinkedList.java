public class TaskLinkedList {

    private TaskNode head;

    // 緊急工作：前端新增
    public void addFirst(String id, String description) {

        if (search(id) != null) {
            System.out.println("工作代碼重複！");
            return;
        }

        TaskNode newNode = new TaskNode(id, description);

        newNode.next = head;
        head = newNode;

        System.out.println("新增緊急工作：" + id);
    }

    // 一般工作：尾端新增
    public void addLast(String id, String description) {

        if (search(id) != null) {
            System.out.println("工作代碼重複！");
            return;
        }

        TaskNode newNode = new TaskNode(id, description);

        if (head == null) {
            head = newNode;
            System.out.println("新增一般工作：" + id);
            return;
        }

        TaskNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println("新增一般工作：" + id);
    }

    // 搜尋
    public TaskNode search(String id) {

        TaskNode current = head;

        while (current != null) {

            if (current.taskId.equals(id)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // 完成工作
    public void finishTask(String id) {

        TaskNode task = search(id);

        if (task == null) {
            System.out.println("找不到工作：" + id);
            return;
        }

        task.completed = true;

        System.out.println("完成工作：" + id);
    }

    // 刪除工作
    public void remove(String id) {

        if (head == null) {
            System.out.println("工作串列為空！");
            return;
        }

        if (head.taskId.equals(id)) {
            head = head.next;
            System.out.println("已刪除：" + id);
            return;
        }

        TaskNode current = head;

        while (current.next != null &&
               !current.next.taskId.equals(id)) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("找不到工作：" + id);
            return;
        }

        current.next = current.next.next;

        System.out.println("已刪除：" + id);
    }

    // 列出未完成工作
    public void showUnfinished() {

        if (head == null) {
            System.out.println("工作串列為空！");
            return;
        }

        System.out.println("\n===== 未完成工作 =====");

        TaskNode current = head;

        boolean found = false;

        while (current != null) {

            if (!current.completed) {

                System.out.println(current.taskId + " - "
                        + current.description);

                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("全部工作皆已完成！");
        }
    }

    // 統計
    public void showStatistics() {

        int total = 0;
        int unfinished = 0;

        TaskNode current = head;

        while (current != null) {

            total++;

            if (!current.completed) {
                unfinished++;
            }

            current = current.next;
        }

        System.out.println("\n===== 工作統計 =====");
        System.out.println("工作總數：" + total);
        System.out.println("未完成數量：" + unfinished);
    }
}
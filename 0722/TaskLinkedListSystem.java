public class TaskLinkedListSystem {

    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        // 一般工作
        list.addLast("T001", "完成 Java 作業");

        list.addLast("T002", "閱讀 Linked List");

        // 緊急工作
        list.addFirst("T003", "繳交期中報告");

        list.addFirst("T004", "修正程式錯誤");

        // 重複代碼
        list.addLast("T002", "Duplicate");

        // 完成工作
        list.finishTask("T001");

        // 找不到
        list.finishTask("T999");

        // 顯示未完成
        list.showUnfinished();

        // 刪除第一個
        list.remove("T004");

        // 刪除最後一個
        list.remove("T002");

        // 找不到
        list.remove("T100");

        // 再顯示一次
        list.showUnfinished();

        // 統計
        list.showStatistics();
    }
}
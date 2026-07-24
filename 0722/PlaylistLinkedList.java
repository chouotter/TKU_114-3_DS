public class PlaylistLinkedList {

    private PlaylistNode head;


    public void addLast(String songId, String songName) {

        if (search(songId) != null) {
            System.out.println("歌曲代碼重複，新增失敗！");
            return;
        }

        PlaylistNode newNode = new PlaylistNode(songId, songName);

        if (head == null) {
            head = newNode;
            return;
        }

        PlaylistNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }


    public PlaylistNode search(String songId) {

        PlaylistNode current = head;

        while (current != null) {

            if (current.songId.equals(songId)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }


    public void remove(String songId) {

        if (head == null) {
            System.out.println("播放清單為空！");
            return;
        }


        if (head.songId.equals(songId)) {
            head = head.next;
            System.out.println("已刪除：" + songId);
            return;
        }

        PlaylistNode current = head;

        while (current.next != null &&
               !current.next.songId.equals(songId)) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("找不到歌曲：" + songId);
            return;
        }


        current.next = current.next.next;

        System.out.println("已刪除：" + songId);
    }


    public void playAll() {

        if (head == null) {
            System.out.println("播放清單為空！");
            return;
        }

        System.out.println("===== 播放清單 =====");

        PlaylistNode current = head;

        while (current != null) {

            System.out.println(current.songId + " - " + current.songName);

            current = current.next;
        }
    }
}
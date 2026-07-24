public class PlaylistSystem {

    public static void main(String[] args) {

        PlaylistLinkedList playlist = new PlaylistLinkedList();

        
        playlist.addLast("S001", "See You Again");
        playlist.addLast("S002", "Believer");
        playlist.addLast("S003", "Faded");
        playlist.addLast("S004", "Counting Stars");

       
        playlist.addLast("S002", "Duplicate");

    
        playlist.playAll();

     
        PlaylistNode song = playlist.search("S003");

        if (song != null) {
            System.out.println("\n找到歌曲："
                    + song.songId + " "
                    + song.songName);
        }

  
        song = playlist.search("S100");

        if (song == null) {
            System.out.println("\n找不到 S100");
        }

  
        playlist.remove("S001");

    
        playlist.remove("S004");


        playlist.remove("S999");

        System.out.println();

        playlist.playAll();
    }
}
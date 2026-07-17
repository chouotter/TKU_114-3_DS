import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = readText(sc);

        System.out.println("\n===== 分析結果 =====");
        System.out.println("原始字元數：" + countOriginalLength(text));
        System.out.println("有效字元數：" + countTrimLength(text));

        String[] words = splitWords(text);

        System.out.println("單字數量：" + words.length);
        System.out.println("母音總數：" + countVowels(text));
        System.out.println("最長單字：" + findLongestWord(words));

        System.out.print("請輸入關鍵字：");
        String keyword = sc.nextLine();

        int count = countKeyword(words, keyword);

        System.out.println("關鍵字出現次數：" + count);

        sc.close();
    }

    public static String readText(Scanner sc) {
        String text;

        while (true) {
            System.out.print("請輸入一行文字：");
            text = sc.nextLine();

            if (!text.trim().isEmpty()) {
                return text;
            }

            System.out.println("不可輸入空字串或全空白，請重新輸入！");
        }
    }


    public static int countOriginalLength(String text) {
        return text.length();
    }


    public static int countTrimLength(String text) {
        return text.trim().length();
    }


    public static String[] splitWords(String text) {
        return text.trim().split("\\s+");
    }


    public static int countVowels(String text) {
        int count = 0;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i'
                    || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }


    public static String findLongestWord(String[] words) {
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    public static int countKeyword(String[] words, String keyword) {
        int count = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }

        return count;
    }

}
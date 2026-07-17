import java.util.Scanner;

/*
==========================================
DebuggingChallenge.java
除錯紀錄
==========================================

1.
錯誤位置：
for 迴圈
for (int i = 0; i <= scores.length; i++)

錯誤類型：
ArrayIndexOutOfBoundsException（陣列越界）

原因：
最後一次 i = scores.length，
陣列最大索引只有 scores.length - 1。

修正方式：
改成
for (int i = 0; i < scores.length; i++)

------------------------------------------

2.
錯誤位置：
double average = total / scores.length;

錯誤類型：
整數除法

原因：
兩個 int 相除，小數會被捨去。

修正方式：
改成

double average = (double) total / scores.length;

------------------------------------------

3.
錯誤位置：
String command = sc.nextLine();

錯誤類型：
Scanner 換行問題

原因：
nextInt() 讀完後換行字元仍留在輸入緩衝區，
nextLine() 直接讀到空字串。

修正方式：
先加入

sc.nextLine();

再讀真正字串。

------------------------------------------

4.
錯誤位置：
if (command == "exit")

錯誤類型：
字串比較錯誤

原因：
== 比較的是記憶體位置，
不是字串內容。

修正方式：
改成

command.equalsIgnoreCase("exit")

------------------------------------------

5.
錯誤位置：
System.out.println("系統結束，年齡：" + age)

錯誤類型：
編譯錯誤

原因：
少了分號。

修正方式：
補上 ;

------------------------------------------

Breakpoint 記錄：

第一次進入 for：
i = 0
scores[i] = 80
total = 0

第二次：
i = 1
scores[i] = 75
total = 80

第三次：
i = 2
scores[i] = 92
total = 155

離開迴圈：
total = 247
average = 82.33

==========================================
*/

public class DebuggingChallenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] scores = {80, 75, 92};

        int total = 0;

      
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

   
        double average = (double) total / scores.length;

        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

    
        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();


        if (command.equalsIgnoreCase("exit")) {
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();

    }

}
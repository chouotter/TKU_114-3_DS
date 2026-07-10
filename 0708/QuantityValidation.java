import java.util.Scanner;

public class QuantityValidation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantity;

        
        while (true) {
            System.out.print("請輸入商品數量：");
            quantity = sc.nextInt();

            if (quantity > 0) {
                break; 
            } else {
                System.out.println("數量必須大於 0，請重新輸入！");
            }
        }

        System.out.println("商品數量：" + quantity);

        sc.close();
    }
}
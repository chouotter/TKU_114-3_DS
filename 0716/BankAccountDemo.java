public class BankAccountDemo {

    public static void main(String[] args) {


        BankAccount account1 = new BankAccount("A001", "王小明", 10000);
        BankAccount account2 = new BankAccount("A002", "陳小華", 5000);

        System.out.println("=== 初始資料 ===");
        System.out.println(account1);
        System.out.println(account2);

 
        System.out.println("\n=== 存款 3000 ===");
        if (account1.deposit(3000)) {
            System.out.println("存款成功");
        } else {
            System.out.println("存款失敗");
        }
        System.out.println(account1);


        System.out.println("\n=== 提款 2000 ===");
        if (account1.withdraw(2000)) {
            System.out.println("提款成功");
        } else {
            System.out.println("提款失敗");
        }
        System.out.println(account1);


        System.out.println("\n=== 成功轉帳 4000 ===");
        if (account1.transferTo(account2, 4000)) {
            System.out.println("轉帳成功");
        } else {
            System.out.println("轉帳失敗");
        }

        System.out.println(account1);
        System.out.println(account2);


        System.out.println("\n=== 失敗轉帳 50000 ===");
        if (account1.transferTo(account2, 50000)) {
            System.out.println("轉帳成功");
        } else {
            System.out.println("轉帳失敗");
        }

        System.out.println(account1);
        System.out.println(account2);
    }
}
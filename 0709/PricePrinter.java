public class PricePrinter {
    public static void main(String[] args) {
        printItem("Apple", 30);
        printItem("Milk", 80);
    }

    public static void printItem(String name,int price) {
        System.out.println("商品:"+name+" 價格:"+price);
    }
}

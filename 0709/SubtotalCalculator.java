public class SubtotalCalculator {

    public static void main(String[] args) {

        int subtotal = calculateSubtotal(50, 3);

        System.out.println("小計：" + subtotal);

    }

    public static int calculateSubtotal(int price, int quantity) {

        return price * quantity;

    }

}
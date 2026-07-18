public class RectangleDemo {

    public static void main(String[] args) {


        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = new Rectangle(8, 8);
        Rectangle r3 = new Rectangle(3.5, 7);

        Rectangle[] rectangles = {r1, r2, r3};

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("===== 矩形 " + (i + 1) + " =====");
            System.out.println(rectangles[i]);
            System.out.println("面積：" + rectangles[i].calculateArea());
            System.out.println("周長：" + rectangles[i].calculatePerimeter());
            System.out.println("是否為正方形：" + rectangles[i].isSquare());
            System.out.println();
        }
    }
}
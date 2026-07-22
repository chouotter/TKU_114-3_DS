public class CartItem {

    private String id;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "代碼：" + id +
                "\n名稱：" + name +
                "\n單價：" + price +
                "\n數量：" + quantity +
                "\n小計：" + getSubtotal();
    }
}
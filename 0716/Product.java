public class Product {


    private String name;
    private int price;
    private int stock;


    public Product(String name, int price, int stock) {


        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }


        if (price > 0) {
            this.price = price;
        } else {
            this.price = 1;
        }


        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }


    public boolean setPrice(int price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }


    public boolean restock(int amount) {
        if (amount > 0) {
            stock += amount;
            return true;
        }
        return false;
    }


    public boolean sell(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > stock) {
            return false;
        }

        stock -= amount;
        return true;
    }


    public boolean isLowStock() {
        return stock < 10;
    }


    public int getInventoryValue() {
        return price * stock;
    }


    @Override
    public String toString() {
        return "商品名稱：" + name +
               "，價格：" + price +
               "，庫存：" + stock;
    }
}
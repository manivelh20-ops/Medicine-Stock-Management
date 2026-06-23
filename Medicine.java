public class Medicine {

    int id;
    String name;
    String category;
    double price;
    int quantity;
    String expiryDate;

    public Medicine(int id, String name, String category,
                    double price, int quantity, String expiryDate) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }
}
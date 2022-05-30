package entities;

public class Product {

    private String name;
    private double value;
    private int quantity;

    public Product(String name, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public Product(String[] in) {

        name = in[0];
        value = Double.parseDouble(in[1]);
        quantity = Integer.parseInt(in[2]);

    }

    public double totalValue() { return quantity * value; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

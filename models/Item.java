package models;

public class Item {
    private String name;
    private double price;
  

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Item(Item source){
        this.name = source.getName();
        this.price = source.getPrice();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";

    }
}

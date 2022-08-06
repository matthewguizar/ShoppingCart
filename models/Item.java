package models;

public class Item {
    private String name;
    private double price;
  

    public Item(String name, double price){
       checkName(name);
       checkPrice(price);
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
        checkName(name);
        this.name = name;
    }

    public void setPrice(double price) {
       checkPrice(price);
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": $" + price + " ";

    }

    public void checkPrice(double price){
        if (price < 0){
            throw new IllegalArgumentException("cannot be less than zero");
        }
    }

    public void checkName(String name){
        if (name.isBlank() || name == null){
            throw new IllegalArgumentException("cannot be null or blank");
        }
    }
}

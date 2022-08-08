package models;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Item)){
            return false;
        }
        Item item = (Item) obj;
        return this.name.equals(item.name) &&
        this.price == item.price;
    }
    //equal objects must have the same HashCode or will lead to bugs when dealing with hash based collections
    public int hashCode() {
        return Objects.hash(name, price);
        
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

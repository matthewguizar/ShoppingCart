package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
    ArrayList<Item> items;


    public Cart(){
        items = new ArrayList<Item>();
    }

    public Item getItems(int index) {
        return new Item(this.items.get(index));
    }

    public void setItems(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item){
        this.items.add(new Item(item));
        return true;
    }

    public void remove(String name){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)){
                items.remove(i);
            }            
        }
    }

    public String checkout(){
        double [] checkout = new double[3];
        for (int i = 0; i < this.items.size(); i++) {
            //looping through cart getting subtotal adding it as first element
            checkout[0] += items.get(i).getPrice();
            
        }
        //using subtotal to get the the tax
        checkout[1] = checkout[0] * 0.13;
        //calculating total after tax
        checkout[2] = checkout[1] + checkout[0];
        return 
        "\tRECEIPT\n\n" +
        "\tSubtotal: $" + checkout[0] + "\n" +
        "\tTax: $" + checkout[1] + "\n" +
        "\tTotal: $" + checkout[2] + "\n";

    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
            temp += "\n";
            
        }
        return temp;
    }
    
}

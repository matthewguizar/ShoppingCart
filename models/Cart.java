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


   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
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

 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */

    public String checkout(){
        
    }
    
}

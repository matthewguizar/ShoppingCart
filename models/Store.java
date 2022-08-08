package models;

public class Store {
    private Item[][] items;


    public Store(){
        //2D array = [row][columns] {7 rows and 3 elements in each row}
        items = new Item[7][3];
    }

    public Item getItems(int row, int column) {
        return new Item(items[row][column]);
    }

    public void setItems(int row, int column, Item item) {
        this.items[row][column] = new Item(item);
    }
}

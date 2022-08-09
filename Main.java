import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            loadItems("products.txt");
            manageItems();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
       
       
    }

    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:     
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */
    public static void manageItems(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store + "\n");

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String choice = scan.nextLine();
            switch (choice){
                case "a": System.out.println("\nchoose an aisle between 1 - 7: ");
                int row = scan.nextInt()-1;
                //to avoid nextLine trap adding throw away nextline
                scan.nextLine();
                System.out.println("choose an item number between 1-3: ");
                //subtracting one because arrays are indexed at zero
                int column = scan.nextInt() - 1;
                //using nextline after next int to avoid trap
                scan.nextLine();
                Item item = store.getItems(row, column);
                //if the item isn't not added to cart because add returns true or false
               if( !(cart.add(item)) ){
                    System.out.println("item already in cart");
               } else {
                   System.out.println(item.getName() + " was added to your shopping cart."); 
                }
                break;
                case "b": System.out.println("enter the item you'd like to remove: ");
                String name = scan.nextLine();
                cart.remove(name);
                break;
                case "c": cart.checkout();
                break;

            }
            System.out.println("\n\nShopping Cart\n\n " + cart);
            System.out.println("Enter anything to continue: ");
            scan.nextLine();
            
        }
    }

 

  
    public static void loadItems(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        //first loop keeps track of every row gives us row index
        for (int i = 0; scanFile.hasNextLine(); i++){
            //separting each line into a string
            String line = scanFile.nextLine();
            //creating an array which separates each item with price
            String[] items = line.split(";");
            //using another loop  to keep track of every element in a row
            for (int j = 0; j < items.length; j++) {
                //splitting name and price into an array [Pepsi , 1.99]
               String[] fields = items[j].split("=");
               //field at index 0 is the name and field at index 1 is the price 
               store.setItems(i, j, new Item(fields[0], Double.parseDouble(fields[1]))); //using Double.parseDouble to change string to double
            }
            
        }
        scanFile.close();
    }

}

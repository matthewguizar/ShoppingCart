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

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
       

        System.out.println("\n\t******************************JAVA GROCERS******************************\n");

        System.out.println(store + "\n");
       
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
 

    /**
     * Name: loadItems
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   1. loads items from <fileName>.txt.
     *      • while loop runs through every line in <fileName>
     *      • scan.nextLine() picks up the entire line.
     *      • splits each String using the ";" separator.
     *      • splits both fields in each String using the "=" separator.
     *      • Parse each price into a Double.
     *   2. adds all items to the store object's items field.
     */
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

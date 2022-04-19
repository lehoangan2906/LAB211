
package View;

import Controller.Shop;
import Controller.Utilities;
import Entity.Fruit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View {
    
    public void display() throws IOException{
        
        // create a new instance of shop object
        Shop shop = new Shop();
        Utilities utilities = new Utilities();
        
        while(true){
            System.out.println(" -------------  Fruit Shop -------------");
            System.out.println(" ----------- Ordering System -----------");
            System.out.println("|---------------------------------------|");
            System.out.println("| 1.   Create Fruits (for shop owner)   |");
            System.out.println("| 2.   Shopping (buyer)                 |");
            System.out.println("| 3.   View Orders                      |");
            System.out.println("| 4.   Exit                             |");
            System.out.println(" ------------------------------ -------- ");
            
            // get user input choice
            int choose = utilities.getInt("Enter your choice [1 - 4]: ", "Invalid choice, [1 - 4] only", 1, 4);
            
            switch (choose){
                
                case 1:
                    shop.CreateFruit(null);
                    System.out.println("\n");
                    break;
                case 2:
                    shop.Shopping();
                    System.out.println("\n");
                    break;
                case 3:
                    shop.viewOrders();
                    System.out.println("\n");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    
    // display fruits in stock
    public void FruitListDisplay(ArrayList<Fruit> lst){
        System.out.println("\n                                                      In Stock Fruits                                                         ");
        System.out.println("\n  ------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" |     Item       |     Fruit ID     |       Fruit Name        |        Origin         |        Price        |     Quantity     |");
        System.out.println("  ------------------------------------------------------------------------------------------------------------------------------");
          
        
        // for every fruit in the stock, print out their informations
        for (int i = 0; i < lst.size(); i++) {
                System.out.format(" |\t%-10d", i + 1);
                System.out.format("|        %-10s", lst.get(i).getFruitid());
                System.out.format("|        %-17s", lst.get(i).getFruitname());
                System.out.format("|        %-15s", lst.get(i).getOrigin());
                System.out.format("|        %-12.3f$", lst.get(i).getPrice());
                System.out.format("|       %-11d|", lst.get(i).getQuantity());
                System.out.println();
        }
        
        System.out.println("  ------------------------------------------------------------------------------------------------------------------------------\n");
    }
    
    
    // function to print out one order's informations
    public void printOrders(List<Fruit> order){
        // create a new variable total with initial value = 0
        double total = 0;
        
        System.out.println("      ---------------------------------------------------------");
        System.out.println("        Product    |    Quantity    |    Price    |    Amount");
        
        // for each fruit in the order, print out its informations
        for (Fruit f : order) {
            
            System.out.format("\t%-20s", f.getFruitname());
            System.out.format("%-11d", f.getQuantity());
            System.out.format("%-15.2f", f.getPrice());
            
            // amount of a fruit equals to the product of its quantity and its price
            double amount = f.getQuantity() * f.getPrice();
            
            System.out.format("%.2f", amount);
            
            // increment value of total by variable amount
            total += amount;
            System.out.println();
        }
        
        System.out.println("      ---------------------------------------------------------");
        System.out.println("\nTotal: " + total);
    }
    
    
}

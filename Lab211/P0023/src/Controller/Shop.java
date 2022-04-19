package Controller;

import java.io.*;
import java.util.*;
import java.lang.*;
import Entity.Fruit;
import Controller.Utilities;
import View.View;

public class Shop {

    Utilities utilities = new Utilities();
    View view = new View();
    // ArrayList used to store stock informations
    public ArrayList<Fruit> list = new ArrayList<>();
    
    // hashtable used to store orders associated with each customer
    public Hashtable<String, List<Fruit>> orderTable = new Hashtable<>();

    public Shop() {
        list.add(new Fruit("Coco", "Coconut", 2, 10, "VietNam"));
        list.add(new Fruit("Org", "Orange", 3, 15, "VietNam"));
        list.add(new Fruit("Ap", "Apple", 9, 6, "VietNam"));
        list.add(new Fruit("Ban", "Banana", 4, 3, "VietNam"));

    }
    
    
    // search for an ID in the list
    public int searchID(ArrayList<Fruit> list, String id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getFruitid().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    
    /*
    // check if an ID exist in the list or not, if not, return the user's input id, prevent duplicate IDs
    public String getFruitID(ArrayList<Fruit> list, String id){
        while(true){
            //String id = Utilities.getString("Enter the fruit ID: ", "Invalid ID", "[a-zA-Z ]+");
            if (searchID(list, id) >= 0){
                System.out.println("ID existed");
            }else{
                return id;
            }
        }
    }
    */
    
    public void CreateFruit(String value) throws IOException {

        while (true) {
            
            String id;
            
            // if user do not pass in a value for the variable id, then ask 
            // the user to input an id, else set the value of id to the value of the value variable
            if (value == null){
                id = utilities.getString("Enter the fruit id (E.g. Coco): ", "Invalid ID", "[a-zA-Z]+");    // get user input
                //id = getFruitID(id);    // check if an ID exist in the list or not, if not, return the user's input id, prevent duplicate IDs
            }else{
                id = value;
            }
            
            // get user input for the new fruit's informations
            String name = utilities.getString("Enter name of the Product: ", "Invalid name", "[a-zA-Z ]+");
            double price = utilities.getDouble("Enter price of the product ($): ", "Invalid price", 1, Double.MAX_VALUE);
            int quantity = utilities.getInt("Enter quantity of the product: ", "Invalid quantity", 1, Integer.MAX_VALUE);
            String origin = utilities.getString("Enter the origin of the product: ", "Invalid Origin", "[a-zA-Z ]+");
            
            // add a new fruit with these informations to the stock
            list.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Product Added");

            // check user's decision
            String choose = utilities.getString("Do you want to continue adding (Y/N)?", "ReEnter your decision (Y/N)", "^[yYnN]$");
            if (choose.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    
    public void updateFruit() throws IOException{
        
        while(true){
            // ask the user for the id of the fruit to be updated
            String id = utilities.getString("Enter the Fruit id: ", "Invalid id", "[a-zA-Z ]+");

            // search for the index of the fruit has that id in the list
            int index = searchID(list, id);

            // id existed in the list
            if (index >= 0){
                
                // get the new quantity
                int newquant = utilities.getInt("Enter new quantity of the fruit: ", "Invalid value", 0, Integer.MAX_VALUE);
                
                // set the new quantity for the fruit
                list.get(index).setQuantity(newquant);
                System.out.println("Update successfully");
                
                
                // get user's decision
                String choose = utilities.getString("Do you want to continue updating ? (Y/N)", "reEnter your choice (Y/N)", "^[yYnN]$");
                if (choose.equalsIgnoreCase("n")){
                    break;
                }
            }else{
                // id does not exist in the list
                System.out.println("Fruit does not exist");
                
                // get user's decision
                String choose = utilities.getString("Do you want to create new Fruit ? (Y/N)", "reEnter your choice (Y/N)", "^[yYnN]$");
                if (choose.equalsIgnoreCase("y")){
                    System.out.println("Create new fruit");
                    CreateFruit(id);
                }
                else if (choose.equalsIgnoreCase("n")){
                    break;
                }
            }
        }
    }

    
    // function to print out orders of customers
    public void viewOrders() {
        // check for ordertable size, if empty then print out that there's no order yet
        if (orderTable.size() == 0) {
            System.out.println("\nThere's no order yet!\n");
        } else {
            int no = 0; // variable assigned to each order to distinguish them
            
            // for every entry in the order table, print out the key - name of the customer and the value - information of user's order
            for (Map.Entry<String, List<Fruit>> entry : orderTable.entrySet()) {
                String customerName = entry.getKey();   // name of the customer as the key of the entry in the map
                List<Fruit> order = entry.getValue();   // order information of the customer as the value of the entry in the map
                
                // print out order no, customer's name and order information
                System.out.println("\nOrder no: #" + ++no);
                System.out.println("----------------------------");
                System.out.println("\nCustomer: " + customerName);
                view.printOrders(order);
                System.out.println("================================================");
            }
        }
    }
    
    
    // function to find fruit by its id
    public Fruit FindFruit(String id) {
        
        // for every fruit in the stock, if that fruit's id equal to the desired id then return that fruit, else return null
        for (Fruit fruit : list) {
            if (fruit.getFruitid().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }
    
    
    // function to get fruit by its index in the stock
    public Fruit getFruitByIndex(int index){
        
        // initialize a vairable countItem to count items exist in the stock, initial value = 0
        int countItem = 0;
        
        // traverse the stock list
        for (Fruit fruit : list){
            // if fruit quantity != 0 => that fruit exist => increment the countItem
            if (fruit.getQuantity() != 0){
                countItem++;
            }
            
            // if countItem equal to index => fruit with the index == value of countItem is the desired fruit => return that fruit
            if (countItem == index){
                return fruit;
            }
        }
        return null;
    }
        

    
    // helper function for shopping
    public void Shopping() throws IOException {

        // tao mot arrayList chua cac san pham nguoi dung mua
        ArrayList<Fruit> order = new ArrayList<>();

        while (true) {
            
            view.FruitListDisplay(list);
            
            // ask the user to choose fruit by index
            int index = utilities.getInt("\nEnter the index of the Fruit you want to buy: ", "Invalid index", 1, Integer.MAX_VALUE);
            Fruit fruit = getFruitByIndex(index);
            
            
            // if FindFruit function return null then that fruit is not found or may be out of stock
            if (fruit == null) {
                System.out.println("Fruit not found or maybe out of stock");
                continue;
            }

            System.out.println("You selected: " + fruit.getFruitname());

            // get the quantity of that fruit
            int quantity = utilities.getInt("Input the quantity: ", "Invalid quantity [1 - " + fruit.getQuantity() + "]", 1, fruit.getQuantity());

            // check name
            boolean isNameExisted = false;
            
            for (Fruit fr : order) {
                if (fr.getFruitname().equals(fruit.getFruitname())) {
                    // fruit da co trong order, chi can tang quantity
                    fr.setQuantity(fr.getQuantity() + quantity);
                    isNameExisted = true;

                    // cap nhat so luong qua con lai trong kho
                    fruit.setQuantity(fruit.getQuantity() - quantity);
                }
            }

            // fruit chua co trong order
            if (!isNameExisted) {
                // all attributes are from the default attributes of the fruit except for the quantity is the user's input one
                Fruit newFruit = new Fruit(fruit.getFruitid(), fruit.getFruitname(), fruit.getPrice(), quantity, fruit.getOrigin());
                order.add(newFruit);

                // cap nhat lai so luong trong kho
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }

            // het hang trong kho
            if (fruit.getQuantity() == 0) {
                list.remove(fruit);
            }

            String choose = utilities.getString("Do you want to finish the order now (Y/N)?", "Please enter Y/N", "^[yYnN]$");

            if (choose.equalsIgnoreCase("y")) {
                break;
            }
        }

        String customerName = utilities.getString("\nEnter your name: ", "Invalidate name", "[a-zA-Z ]+");

        
        // neu ten khach hang bi trung
        if (orderTable.containsKey(customerName)) {
            customerName += " #" + (orderTable.size() + 1);
        }
        

        // tao mot entry moi trong ordertable chua hoa don cua nguoi dung vua mua
        orderTable.put(customerName, order);
        System.out.println("\nOrder successful!\n");
    }
}

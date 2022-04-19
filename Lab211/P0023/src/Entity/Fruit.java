package Entity;

import Controller.Utilities;

public class Fruit {

    private String fruitid;
    private String fruitname;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitid, String fruitname, double price, int quantity, String origin) {
        this.fruitid = fruitid;
        this.fruitname = fruitname;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitid() {
        return fruitid;
    }

    public void setFruitid(String fruitid) {
        // must be a non empty string
        Utilities utilities = new Utilities();
        this.fruitid = utilities.checkInputString(fruitid);
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        // must be a non empty string
        Utilities utilities = new Utilities();
        this.fruitname = utilities.checkInputString(fruitname);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // must be a positive double
        Utilities utilities = new Utilities();
        if (utilities.checkInputDouble(price)) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // must be a positive integer
        Utilities utilities = new Utilities();
        if (utilities.checkInputInt(quantity)) {
            this.quantity = quantity;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        // must be a non empty string
        Utilities utilities = new Utilities();
        this.origin = utilities.checkInputString(origin);
    }

    @Override
    public String toString() {
        return "       " + fruitid + "           " + fruitname + "          " + price + "            " + quantity + "          " + origin;
    }
    
    
}

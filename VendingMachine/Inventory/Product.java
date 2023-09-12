package Design_Patterns.VendingMachine.Inventory;

public class Product {

    String productID;
    String Name;
    double price;
    public Product(String Name, double price,String productID){
        this.Name=Name;
        this.price=price;
        this.productID=productID;
    }
    public String getproductID(){
        return this.productID;
    }
    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.Name;
    }
}

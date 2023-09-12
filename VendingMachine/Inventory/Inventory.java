package Design_Patterns.VendingMachine.Inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Inventory {
    private HashMap<Integer,Product> aisleToProduct;
    private HashMap<String,Integer> productIDToQuantity;
    Queue<Integer>availableAisle;

    public Inventory(int aisleCount){
        availableAisle= new LinkedList<>();
        for(int i=1;i<=aisleCount;i++){
            availableAisle.add(i);
        }
        aisleToProduct=new HashMap<>();
        productIDToQuantity=new HashMap<>();
    }
    public void addProduct(Product product) throws Exception {
        String productID= product.getproductID();
        int productCount=productIDToQuantity.getOrDefault(productID,0);
        if(productCount==0){
            if(availableAisle.isEmpty()){
                throw new Exception("No Space Available");
            }
            else{
                aisleToProduct.put(availableAisle.poll(),product);
            }
        }
        productIDToQuantity.put(productID,productCount+1);
    }
    public Product getProduct(int aisleNumber){
        return aisleToProduct.get(aisleNumber);
    }
    public boolean isProductAvailable(int aisleNumber){
        if(!aisleToProduct.containsKey(aisleNumber)) return false;
        Product p= aisleToProduct.get(aisleNumber);
        String productID= p.getproductID();
        int productCount=productIDToQuantity.get(productID);
        return productCount>0;
    }
    public void deductProductCount(int aisleNumber){
        String productId=aisleToProduct.get(aisleNumber).getproductID();
        int count=productIDToQuantity.get(productId);
        if(count-1==0){
            productIDToQuantity.remove(productId);
            aisleToProduct.remove(aisleNumber);
            availableAisle.offer(aisleNumber);
        }
        else {
            productIDToQuantity.put(productId,count-1);
        }
    }
    public void display(){
        for (int a:aisleToProduct.keySet()) {
            Product p=aisleToProduct.get(a);
            System.out.println(a + " " + p.productID + "  " + p.getName());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (String key :productIDToQuantity.keySet()){
            System.out.println(key+" "+productIDToQuantity.get(key));
        }
    }
}

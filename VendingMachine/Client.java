package Design_Patterns.VendingMachine;

import Design_Patterns.VendingMachine.Inventory.Product;
import Design_Patterns.VendingMachine.vendingMachine.VendingMachine;

public class Client {
    public static void main(String[] args) {
        VendingMachine vm= new VendingMachine();
        Product harshley= new Product("Harshley",100.0,"h_78");
        for(int i=1;i<=3;i++){
            vm.addProduct(harshley);
        }
        Product berkins= new Product("berkins",88.0,"b_60");
        for(int i=1;i<=3;i++){
            vm.addProduct(berkins);
        }
        vm.getInventory().display();
        vm.insertCoin(100);
        vm.pressButton(1);
        vm.insertCoin(80);
        vm.pressButton(2);

    }
}

package Design_Patterns.VendingMachine.State;

import Design_Patterns.VendingMachine.Inventory.Inventory;
import Design_Patterns.VendingMachine.Inventory.Product;
import Design_Patterns.VendingMachine.vendingMachine.VendingMachine;

public class CoinInsertState implements State{

    VendingMachine vending_machine;
    public CoinInsertState(VendingMachine vm){
        this.vending_machine=vm;
    }
    @Override
    public void insertCoin(double amount) {
        vending_machine.setAmount(vending_machine.getAmount()+amount);
    }

    @Override
    public void pressButton(int aisleNumber) {
        Inventory inventory= vending_machine.getInventory();
        if(!inventory.isProductAvailable(aisleNumber)){
            throw new IllegalStateException("Product not available");
        }
        Product product=inventory.getProduct(aisleNumber);
        if(!vending_machine.hasSufficientAmount(product.getPrice())){
            throw new IllegalStateException("Insufficient Amount of money");
        }

        vending_machine.setCurrVendingMachineState(vending_machine.getDispenseState());
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalStateException("Select the Product First");
    }
}

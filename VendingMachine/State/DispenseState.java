package Design_Patterns.VendingMachine.State;

import Design_Patterns.VendingMachine.Inventory.Inventory;
import Design_Patterns.VendingMachine.Inventory.Product;
import Design_Patterns.VendingMachine.vendingMachine.VendingMachine;

public class DispenseState implements State{
    VendingMachine vending_machine;
    public DispenseState(VendingMachine vm){
        this.vending_machine=vm;
    }
    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("product getting dispensed");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("product getting dispensed");
    }

    @Override
    public void dispense(int aisleNumber) {
        Inventory inventory= vending_machine.getInventory();
        Product product= inventory.getProduct(aisleNumber);
        inventory.deductProductCount(aisleNumber);
        double change=vending_machine.getAmount()- product.getPrice();
        vending_machine.setAmount(0);
        vending_machine.setCurrVendingMachineState(vending_machine.getNoCoinInsertedState());

        System.out.println("Product :"+product.getName() + " is Dispensed and The remaining Change is "+ change+"." );
    }
}

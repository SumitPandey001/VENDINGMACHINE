package Design_Patterns.VendingMachine.State;

import Design_Patterns.VendingMachine.vendingMachine.VendingMachine;

public class NoCoinInsertedState implements State{

    VendingMachine vending_machine;
    public NoCoinInsertedState(VendingMachine vm){
        this.vending_machine=vm;
    }
    @Override
    public void insertCoin(double amount) {
        vending_machine.setAmount(amount);
        vending_machine.setCurrVendingMachineState(vending_machine.getCoinInsertState());
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("NO coin is inserted");
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalStateException("NO coin is inserted");
    }
}

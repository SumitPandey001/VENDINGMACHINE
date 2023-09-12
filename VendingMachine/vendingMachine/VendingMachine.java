package Design_Patterns.VendingMachine.vendingMachine;

import Design_Patterns.VendingMachine.Inventory.Inventory;
import Design_Patterns.VendingMachine.Inventory.Product;
import Design_Patterns.VendingMachine.State.CoinInsertState;
import Design_Patterns.VendingMachine.State.DispenseState;
import Design_Patterns.VendingMachine.State.NoCoinInsertedState;
import Design_Patterns.VendingMachine.State.State;

public class VendingMachine {
    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertState coinInsertState;
    private DispenseState dispenseState;
    private Inventory inventory;
    private State currVendingMachineState;
    private double amount;

    private static final int Aisle_count=2;

    public VendingMachine(){
        noCoinInsertedState=new NoCoinInsertedState(this);
        coinInsertState= new CoinInsertState(this);
        dispenseState= new DispenseState(this);
        currVendingMachineState=noCoinInsertedState;
        amount=0.0;
        inventory= new Inventory(Aisle_count);
    }
    public boolean hasSufficientAmount(double price){
        return price<=this.amount;
    }
    public NoCoinInsertedState getNoCoinInsertedState(){
        return noCoinInsertedState;
    }
    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState){
        this.noCoinInsertedState=noCoinInsertedState;
    }

    public CoinInsertState getCoinInsertState(){
        return coinInsertState;
    }
    public void setCoinInsertState(CoinInsertState coinInsertState){
        this.coinInsertState=coinInsertState;
    }

    public DispenseState getDispenseState(){
        return dispenseState;
    }
    public void setDispenseState(DispenseState dispenseState){
        this.dispenseState= dispenseState;
    }

    public State getCurrVendingMachineState(){
        return currVendingMachineState;
    }
    public void setCurrVendingMachineState(State currVendingMachineState){
        this.currVendingMachineState=currVendingMachineState;
    }

    public Inventory getInventory(){
        return this.inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory=inventory;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }
    public double getAmount(){
        return amount;
    }
    public void insertCoin(double amount){
        //Runtime poly..
        //it will check state and insertCoin
        this.currVendingMachineState.insertCoin(amount);
        System.out.println("Coin Inserted: "+ amount);
    }

    public void pressButton(int aisleNumber){
        this.currVendingMachineState.pressButton(aisleNumber);
        this.currVendingMachineState.dispense(aisleNumber);
    }

    public void addProduct(Product product){
        try{
            this.inventory.addProduct(product);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

package Design_Patterns.VendingMachine.State;
//NoCoinInserted -> CoinInserted -> DispenseState -> NoCoinInsertedState
public interface State {
    public void insertCoin(double amount);
    public void pressButton(int aisleNumber);
    public void dispense(int aisleNumber);
}

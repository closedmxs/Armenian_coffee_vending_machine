package payment_system;

import main.Beverage;

public class Balance {
    private int  balance;
    private int charge;

    public Balance(){
        balance = 0;
        charge = 0;
    }

    public void addBalance(int money){
        if (money > 0) {
            balance += money;
            System.out.println("You successfully added " + money + " amount of money");
        }
    }

    public boolean hasEnoughMoney(Beverage beverage){
        return this.balance>=beverage.getPrice();
    }


    public int purchase(Beverage beverage) {

        if (balance >= beverage.getPrice()) {

            int charge = balance - beverage.getPrice();
            balance = 0;

            return charge;
        }

        return -1;
    }

}

package main;
import payment_system.Balance;
import payment_system.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Balance balance = new Balance();


        Scanner sc = new Scanner(System.in);
        System.out.print("Insert money: ");
        int money = sc.nextInt();

        balance.addBalance(money);

        for (int i = 0; i < Menu.MENU.size(); i++) {
            Beverage element = Menu.MENU.get(i);

            System.out.println((i + 1) + ". "
                    + element.getName()
                    + " "
                    + element.getPrice());
        }

        System.out.print("Choose option: ");
        int option = sc.nextInt();

        int index = option - 1;

        if (index < 0 || index >= Menu.MENU.size()) {
            System.out.println("Invalid option!");
            return;
        }

        Beverage selected = Menu.MENU.get(index);

        System.out.println("You selected: " + selected.getName());


        if (balance.hasEnoughMoney(selected)) {
            System.out.print("How much sugar you want out of 5: ");
            int sugar = sc.nextInt();
            int change = balance.purchase(selected);
            selected.setSugar(sugar);
            System.out.println("Your change: " + change);
            System.out.print("Making coffee: [");

            for (int i = 0; i < 20; i++) {

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.print("=");
            }

            System.out.println("] Done!");

        } else {
            System.out.println("Not enough balance!");
        }
    }
}

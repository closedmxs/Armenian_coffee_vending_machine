package main;

public class Beverage {
    private int price;
    private String name;
    private int sugar_lvl;

    public Beverage(){
        price = 0;
        name = "";
        sugar_lvl = 0;
    }

    public Beverage(int price, String name){
        if(price > 0)
            this.price = price;
        if(name != null)
            this.name = name;
    }

    public int getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public void setSugar(int sugar){
        if (sugar > 0 && sugar < 6) {
            this.sugar_lvl = sugar;
        }
    }

}

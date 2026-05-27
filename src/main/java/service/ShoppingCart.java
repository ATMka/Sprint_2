package service;

import model.Food;

public class ShoppingCart {
    private Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double getTotalPriceWithoutDiscount(Food[] foods){
        double totalPrice = 0;
        for(int i = 0; i < foods.length; i++){
            totalPrice += foods[i].getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount(Food[] foods){
        double totalPrice = 0;
        for(int i = 0; i < foods.length; i++){
            if(foods[i].getDiscount(foods[i].getPrice()) != 0){
                totalPrice += foods[i].getPrice() * foods[i].getDiscount(foods[i].getPrice()) / 100;
            }
            else {
                totalPrice += foods[i].getPrice();
            }
        }
        return totalPrice;
    }
}

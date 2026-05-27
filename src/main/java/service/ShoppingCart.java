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
            totalPrice += foods[i].getAmount() * foods[i].getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount(Food[] foods){
        double totalPrice = 0;
        for(int i = 0; i < foods.length; i++){
            if(foods[i].getDiscount() != 0){
                totalPrice += (foods[i].getAmount() * foods[i].getPrice()) * foods[i].getDiscount() / 100;
            }
            else {
                totalPrice += foods[i].getAmount() * foods[i].getPrice();
            }
        }
        return totalPrice;
    }

    public double getTotalPriceVeganFoodWithoutDiscount(Food[] foods){
        double totalPrice = 0;
        for(int i = 0; i < foods.length; i++){
            if(foods[i].isVegetarian() && foods[i].getDiscount() == 0){
                totalPrice += foods[i].getAmount() * foods[i].getPrice();
            }
        }
        return totalPrice;
    }

}

package service;

import model.Food;

public class ShoppingCart {
    private Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double getTotalPriceWithoutDiscount(){
        double totalPrice = 0;
        for(int i = 0; i < this.foods.length; i++){
            totalPrice += this.foods[i].getAmount() * this.foods[i].getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount(){
        double totalPrice = 0;
        for(int i = 0; i < this.foods.length; i++){
            if(this.foods[i].getDiscount() != 0){
                totalPrice += (this.foods[i].getAmount() * this.foods[i].getPrice()) * this.foods[i].getDiscount() / 100;
            }
            else {
                totalPrice += this.foods[i].getAmount() * this.foods[i].getPrice();
            }
        }
        return totalPrice;
    }

    public double getTotalPriceVeganFoodWithoutDiscount(){
        double totalPrice = 0;
        for(int i = 0; i < this.foods.length; i++){
            if(this.foods[i].isVegetarian() && this.foods[i].getDiscount() == 0){
                totalPrice += this.foods[i].getAmount() * this.foods[i].getPrice();
            }
        }
        return totalPrice;
    }

}

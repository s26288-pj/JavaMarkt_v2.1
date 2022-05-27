package model;

import discounts.FreeCupDiscount;
import discounts.ICanApplyDiscount;
import discounts.PercentDiscount;

import java.util.ArrayList;

public class Cart {
    ArrayList<CartItem> items = new ArrayList<CartItem>();

    public double totalPriceOfProducts() {
        double sum = 0;
        for(CartItem item : items) {
            sum+=item.getProduct().getPrice();
        }
        return sum;
    }

    public double totalPriceOfDiscountedProducts() {
        double sum = 0;
        for(CartItem item : items) {
            sum+=item.getCurrentPrice();
        }
        return sum;
    }

    public void applyDiscount(ICanApplyDiscount discount) {
        if(discount.canApplyDiscount(this))
            discount.applyDiscount(this);
    }

//    public void applyDiscount(FreeCupDiscount discount) {
//        if(discount.canApplyDiscount(this))
//            discount.applyDiscount(this);
//    }
    public ArrayList<CartItem> getItems() {
        return items;
    }
}

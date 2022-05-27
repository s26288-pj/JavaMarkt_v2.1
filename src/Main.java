import discounts.FreeCupDiscount;
import discounts.PercentDiscount;
import model.CartItem;
import model.Product;
import model.Cart;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Product> getSampleProducts() {
        ArrayList<Product> sample = new ArrayList<Product>();
        for(int i=1; i<=5;i++) {
            Product p = new Product();
            p.setName("Product"+i);
            p.setPrice(i*25);
            sample.add(p);
        }
        return sample;
    }

    public static Cart getSampleCart() {
        Cart cart = new Cart();
        for(Product p: getSampleProducts()) {
            cart.getItems().add(new CartItem(p));
        }
        return cart;
    }

    public static void printCart(Cart cart) {
        System.out.println("=========================================");
        System.out.println("|Nazwa produktu\t|Cena\t|Cena promocyjna|");
        System.out.println("-----------------------------------------");
        for(CartItem item: cart.getItems()) {
            System.out.println("|"
            + item.getProduct().getName() + "\t|"
            + item.getProduct().getPrice() + "\t|"
            + item.getCurrentPrice() + "\t|");
            System.out.println("-----------------------------------------");
        }
        System.out.println("Suma: " + cart.totalPriceOfProducts());
        System.out.println("Suma po promocji: " + cart.totalPriceOfDiscountedProducts());
    }

    public static void main(String[] args) {
        Cart cart = getSampleCart();
        cart.applyDiscount(new FreeCupDiscount());
        printCart(cart);
        cart.applyDiscount(new PercentDiscount(0.05));
        printCart(cart);
    }
}

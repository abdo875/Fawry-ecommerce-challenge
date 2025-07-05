import java.util.ArrayList;
import java.util.List;
public class CheckoutService {
    public static void checkout(Customer customer){
        Cart cart = customer.getCart();
        if(cart.isEmpty()){
            System.out.println("Cart Is Empty");
            return;
        }
        double subtotal= 0;
        List<Shippable> shippingItems = new ArrayList<>();
        for(CartItem item:cart.getItems()){
            Product p = item.getProduct();
            int qty = item.getQuantity();
            if(p.isExpired()){
                System.out.println("Product "+p.getName()+" is expired");
                return;
            }
            if(qty>p.getQuantity()){
                System.out.println("Not Enough stock for "+p.getName());
                return;
            }
            subtotal = subtotal +p.getPrice()*qty;
            p.reduceQuantity(qty);
            if(p.isShippable()){
                for (int i=0;i<qty;i++) {
                    shippingItems.add(p);
                }
            }
        }
        double totalWeight = 0;
        for(Shippable item:shippingItems){
            totalWeight = totalWeight+item.getWeight();
        }
        double shippingfees = totalWeight >0 ? 30:0;
        double totalAmount = subtotal+shippingfees;
        if(customer.getBalance()<totalAmount){
            System.out.println("Youre Balance Not Enough");
            return;
        }
        customer.pay(totalAmount);
        if(!shippingItems.isEmpty()){
            ShippingService.send(shippingItems);
        }
        System.out.println("** Checkout receipt **");
        for(CartItem item:cart.getItems()){
            double price_of_line = item.getProduct().getPrice() * item.getQuantity();
            Product product = item.getProduct();
            int qty = item.getQuantity();
            System.out.println(qty+"x "+product.getName()+" "+(int)price_of_line);
        }
        System.out.println("------------------------");
        System.out.println("Subtotal "+(int)subtotal);
        System.out.println("Shipping "+(int)shippingfees);
        System.out.println("Amount "+(int)totalAmount);
        System.out.println("Cstomer current balance: "+(int)customer.getBalance());
    }

}

import java.util.ArrayList;
import java.util.List;
public class Cart {
    private List<CartItem> items;
    public Cart(){
        this.items = new ArrayList<>();
    }
    public boolean add(Product product, int quantity){
        if(quantity <= 0){
            System.out.println("Quantity Must Be Postivie");
            return false;
        }
        if(quantity > product.getQuantity()){
            System.out.println("Quantity Is Not Enough");
            return false;
        }
        items.add(new CartItem(product,quantity));
        return true;
    }
    public List<CartItem> getItems(){
        return items;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
}

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
public class Main{
public static void main(String[] args) {
        Product chesse = new Product("Chesse",100,10,true,LocalDate.now().plusDays(5),true,0.4);
        Product biscuits = new Product("Biscuits",150,5,true,LocalDate.now().plusDays(10),true,0.7);
        Product tv = new Product("TV",1000,3,false,null,true,0.5);
        Product scratchCard = new Product("ScratchCard", 50, 20, false, null, false, 0.0);
        Customer customer = new Customer("Abdelrahman Mostafa",1000);
        customer.getCart().add(chesse, 5);
        customer.getCart().add(biscuits, 1);
        CheckoutService.checkout(customer);
    }
}

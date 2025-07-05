import java.time.LocalDate;

public class Product implements Shippable{
    private String name;
    private double price;
    private int quantity;
    private boolean isExpiar;
    private LocalDate expiarDate;
    private boolean isShippable;
    private double weight;
    public Product(String name,double price,int quantity,boolean isExpiar
    ,LocalDate expiarDate,boolean isShippable,double weight){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isShippable = isShippable;
        this.isExpiar = isExpiar;
        this.expiarDate = expiarDate;
        this.weight = weight;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public boolean isExpiarable(){
        return isExpiar;
    }
    public LocalDate getExpiarData(){
        return expiarDate;
    }
    public boolean isExpired(){
        if (!isExpiar) {
            return false;
        }
        return expiarDate.isBefore(LocalDate.now());
    }
    public boolean isShippable(){
        return isShippable;
    }
    @Override
    public double getWeight(){
        return weight;
    }
    public void reduceQuantity(int Quantity){
        quantity = quantity- Quantity;
    }
}
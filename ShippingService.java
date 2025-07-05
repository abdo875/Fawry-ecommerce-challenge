import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class ShippingService {
    public static void send(List<Shippable> items){
        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCounts = new HashMap<>();
        Map<String, Double> itemWeights = new HashMap<>();
        double totalWeight = 0;
        for(Shippable item:items){
            String name = item.getName();
            double weight = item.getWeight();
            itemCounts.put(name, itemCounts.getOrDefault(name, 0)+1);
            itemWeights.put(name,weight);
            totalWeight = totalWeight+weight;
        }
        for(String name:itemCounts.keySet()){
            int qty = itemCounts.get(name);
            double weight = itemWeights.get(name)*qty*1000;
            System.out.println(qty+"x "+name+" "+(int)weight+"g");
        }
        System.out.println("Total package weight "+String.format("%.1f",totalWeight)+"kg");
    }
}

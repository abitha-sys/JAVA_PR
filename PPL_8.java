import java.util.*;

class Order {
   int orderId;
    String foodName;

 Order(int orderId, String foodName) {
       this.orderId = orderId;
        this.foodName = foodName;
}
class DeliveryAgent extends Thread {
   String agentName;
  Order[] orders;
      
DeliveryAgent(String agentName, Order[] orders) {
   this.agentName = agentName;
     this.orders = orders;      
 }
public void run() {
   for (Order order : orders) {
      System.out.println(agentName +"Order placed:"+ order.orderId +" " + order.foodName);
try {
Thread.sleep(2000); 
} catch (InterruptedException e) {
e.printStackTrace();
} 
     System.out.println(agentName +"Order Delivered:"+ order.orderId +" " + order.foodName);
}
}
}
public class PPL8 {
    public static void main(String[] args) {

  Order[] orders1 = { new Order(1, "Pizza"),new Order(2, "Burger")};
   Order[] orders2 = {new Order(3, "Pasta"), new Order(4, "Sandwich") };
   Order[] orders3 = {new Order(5, "Biryani"),new Order(6, "Noodles")};
 
 DeliveryAgent agent1 = new DeliveryAgent("Agent A ", orders1);
  DeliveryAgent agent2 = new DeliveryAgent("Agent B ", orders2);
  DeliveryAgent agent3 = new DeliveryAgent("Agent C ", orders3);

  agent1.start();
 agent2.start();
  agent3.start();
}
}

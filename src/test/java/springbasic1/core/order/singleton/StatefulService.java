package springbasic1.core.order.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // Here is the problem
    }
    public int getPrice(){
        return price;
    }
}

package GreedyAlogrithms;

import java.util.Arrays;

class Item implements Comparable<Item>{
    int weight;
    int price;
    float up;
    Item(int weight, int price){
        this.weight=weight;
        this.price=price;
        up=(float)price/weight;
    }

    float getUP(){
        return up;
    }

    int getWeight(){
        return weight;
    }

    int getPrice(){
        return price;
    }
    @Override
    public int compareTo(Item o) {
        if(up==o.getUP()){
            return 0;
        } else if (up>o.getUP()) {
            return -1;
        }
        return 1;
    }
}
public class fractionalKnapsack {

    static void OptimalFractionalKnapsack(int W,int[]weights,int[]prices){
        Item[]Items=new Item[weights.length];
        for(int i=0;i<weights.length;i++){
            Items[i]=new Item(weights[i],prices[i]);
        }

        Arrays.sort(Items);
        float totalProfit=0;
        for(int i=0;i<Items.length;i++){
            if(W<=0){
                break;
            }

            if(W>=Items[i].getWeight()){
                totalProfit+=Items[i].getPrice();
                System.out.println("Selected item with weight:"+Items[i].getWeight()+",and price:"+Items[i].getPrice());
                W=W-Items[i].getWeight();
            }else {
                float p= (Items[i].getUP()*W);
                totalProfit+=p;
                System.out.println("(Fractional)Selected item with weight:"+W+",and price:"+p);
                W=0;
            }
        }
        System.out.println("Total profit:"+totalProfit);
    }
    public static void main(String[] args) {
        int[]w={2,4,3,6,6};
        int[]p={32,28,15,28,24};
        OptimalFractionalKnapsack(11,w,p);
    }
}

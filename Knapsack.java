import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    static class Item{
        int no, w, p;
        float pw, fraction;
        Item(int no, int w, int p){
            this.no = no;
            this.w = w;
            this.p = p;
            this.pw = (float)Math.round(p*100/w)/100;
            this.fraction = 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of items and capacity of knapsack: ");
        int n = sc.nextInt();
        int m = sc. nextInt();
        
        Item items[] = new Item[n];
        System.out.println("Enter weight and profit of each item: ");
        for(int i=0; i<n; i++){
            System.out.println("Item "+(i+1)+": ");
            int weight = sc.nextInt();
            int profit = sc.nextInt();
            items[i] = new Item(i+1, weight, profit);
        }
        sc.close();
        float profit = 0;
        Arrays.sort(items, (a,b)->Float.compare(b.pw,a.pw));
        for(int i=0; i<n && m>0; i++){
            if(items[i].w <= m){
                items[i].fraction = 1;
                profit += items[i].p;
                m -= items[i].w;
            }
            else{
                items[i].fraction = (float)Math.round(m*100/items[i].w)/100;
                m -= profit += items[i].p*items[i].fraction;
            }
        }
        System.out.println("Profit: "+profit);
        System.out.println("Items: ");
        for(Item item:items) System.out.println(item.no+" "+item.fraction); 
    }
}

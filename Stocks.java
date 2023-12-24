import java.util.*;
public class Stocks{
    public static int profit(int price[]){
        int buyprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int sell=0;sell<price.length;sell++){
            if(buyprice<price[sell]){
                int profit = price[sell]-buyprice;
                maxprofit=Math.max(profit,maxprofit);
            }else{
                buyprice=price[sell];
            }
        }return maxprofit;
    }
    public static void main(String args[]){
        int price[]= {7,1,5,3,6,4};
        System.out.print("maximum profit = "+profit(price));
    }
}
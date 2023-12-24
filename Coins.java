import java.util.*;

public class Coins{
    public static void main(String args[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins,Comparator.reverseOrder());


        int count = 0;
        int amount = 9857;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<coins.length;i++ ){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    count++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                }
            }
        }

        System.out.println("total (min) coins used = " + count);
        System.out.print(ans);
    }
}
/*given n non-negative integers array representing 
an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.*/
import java.util.*;

public class As1{
    public static int trapped(int array[]){
        int left_max[]=new int[array.length];
        int right_max[]=new int[array.length];
        int n=array.length;
        left_max[0]=array[0];
        for(int i=1;i<n;i++){
            if(left_max[i-1]<=array[i]){
                left_max[i]=array[i];
            }else{
                left_max[i]=left_max[i-1];
            }
        }
        right_max[n-1]=array[n-1];
        for(int i=n-2;i>=0;i--){
            if(right_max[i+1]<=array[i]){
                right_max[i]=array[i];
            }else{
                right_max[i]=right_max[i+1];
            }
        }int trappedwater=0;
        for(int i=0;i<n;i++){
            int water=Math.min(right_max[i],left_max[i])-array[i];
            trappedwater+=water;
        }return trappedwater;
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the length of an array = ");
        int l=sc.nextInt();
        int array[]=new int[l];
        System.out.println("now enter value of array one by one ");
        for(int i=0;i<array.length;i++){
            array[i]=sc.nextInt();
        }
        System.out.print("water trapped = "+trapped(array));
    }
}
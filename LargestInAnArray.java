import java.util.*;

public class LargestInAnArray{
    public static int largest(int array[]){
        int l = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            if(array[i]>l){
                l=array[i];
            }
        }return l;
    }
    public static void main(String args[]){
        int array[]={1,8,6,3,5};
        System.out.print("largest no. in array is = "+ largest(array));
    }
}
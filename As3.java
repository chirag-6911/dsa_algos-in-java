//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)
//such  that  the  resulting  array  is [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).
//Given the array nums after the possible rotation and an integer target, returnthe index oftarget if it is in nums, or -1 
//if it is not in nums.

import java.util.*;

public class As3{
    public static int nums(int array[], int target){
        int num[]=new int[array.length];
        int min=Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter indek k = ");
        int k=sc.nextInt();
        for(int i=0;i<num.length;i++){
            for(int j=k;j<num.length;j++){
                num[i]=array[j];
                i++;
            }
            for(int j=0;j<k;j++){
                for(int m=j+1;m<k;m++){
                    if(array[m]<array[j]){
                        int t=array[m];
                        array[m]=array[j];
                        array[j]=t;
                    }
                }
                num[i]=array[j];
                i++;
            }
        }
        for(int i=0;i<num.length;i++){
            if(num[i]==target){
                return i;
            }
        }return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       int array[]={0,1,2,4,5,6,7};
       System.out.print("enter the target = ");
       int target=sc.nextInt();
       System.out.print("index of target is "+nums(array,target));
    }
}
//it's not optimised i still solved it.
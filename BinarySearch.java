import java.util.*;

public class BinarySearch{
    public static int binary(int array[],int key){
        int s = 0;
        int e = array.length-1;
        int mid;
        while(s<=e){
            mid = (e+s)/2;
            if(key==array[mid]){
                return mid;
            }else if(key>array[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the key = ");
        int key = sc.nextInt();
        int array[]= {1,2,3,4,5,6,7,8,9,10}; 
        if(binary(array,key)==-1){
            System.out.print("key not found");
        }else{
            System.out.print("key is at "+ binary(array,key)+ " index");
        }
    }
}
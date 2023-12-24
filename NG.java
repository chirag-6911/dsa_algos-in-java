import java.util.*;

public class NG{


    public static void main(String args[]){
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nextGreter[] = new int [arr.length];

        for(int i = arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nextGreter[i] = -1;
            }else{
                nextGreter[i] = arr[s.peek()];
            }

            s.push(i);
        }
        for(int i=0; i<nextGreter.length; i++){
            System.out.print(nextGreter[i]+" ");
        }
        System.out.println();
    }
}
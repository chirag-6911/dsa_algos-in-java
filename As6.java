import java.util.*;

public class As6{
    public static void main(String args[]){
        int arr[]={2,2,1,1,1,1,2,2,2};
        System.out.print(Majorty(arr) );

    }

    public static int Majorty(int arr[]){
        int count = 0;
        int High_occurance = arr.length/2;

        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>High_occurance){
                return arr[i];

            }
            count = 0 ;
        }

        return -1;
    }

    public static void printarr(String arr[]){
        for(int i=0;i<arr.length;i++){
            if(i==0){
                System.out.print("{ ");
            }
            System.out.print('"'+arr[i]+'"');

            if(i==arr.length-1){
                System.out.print(" }");
            }else{
                System.out.print(" , ");
            }
        }
    }

    public static void Merge_sort(String arr[],int si, int ei){
        //base case

        if(si>=ei){
            return;
        }
        //kaam
        int mid = si+(ei-si)/2;

        Merge_sort(arr,si,mid);//left part
        Merge_sort(arr,mid+1,ei);//right part

        Merge(arr,si,ei,mid);
    }

    public static void Merge(String arr[],int si,int ei,int mid){
        String temp[] = new String[ei-si+1];

        int i = si;//iterator for left part
        int j = mid+1;//iterator for right part
        int k = 0;//iterator for temperay array

        while(i<=mid && j<=ei){
            if((arr[i].compareTo(arr[j]) )< 0){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        
        for(i=si,k=0;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }

    }
}
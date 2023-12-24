import java.util.*;
public class AsSorting{
    public static void print(int array[]){
        for(int i = 0;i<array.length;i++){
        System.out.print(array[i]+",");
        }
        System.out.println();
        }
    public static void countingSort(int array[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            largest=Math.max(array[i],largest);
        }
        int count[]=new int[largest+1];

        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        int j=array.length-1;
        for(int i = 0;i<count.length;i++){
            while(count[i]>0){
                array[j]=i;
                j--;
                count[i]--;
            }
        }
    }public static void selectionSort(int array[]){
        
        for(int i=0;i<array.length;i++){
            int maxpos=i;
            for(int j=i+1;j<array.length;j++){
                if(array[maxpos]<array[j]){
                    maxpos=j;
                }
            }
            int t=array[i];
            array[i]=array[maxpos];
            array[maxpos]=t;
        }
    }
    public static void bubbleSort(int array[]){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j+1]>array[j]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }
    public static void insertionSort(int array[]){
        for(int i=1;i<array.length;i++){
            int curr=array[i];
            int pre=i-1;
            while(pre>=0 && array[pre]<curr){
                array[pre+1]=array[pre];
                pre--;
            }
            array[pre+1]=curr;
        }
    }
    public static void main(String args[]){
        int array[]={3,6,2,1,8,7,4,5,3,1};
        System.out.print("array before sorting= ");
        print(array);
        //Arrays.sort(array);
        //countingSort(array);
        //bubbleSort(array);
        //selectionSort(array);
        insertionSort(array);
        System.out.print("array after sorting= ");
       print(array);
       

    }
}
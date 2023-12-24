import java.util.*;
public class Sorting{
    public static void print(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }System.out.println();
    }
    /*sorting method = time complexity
       bubble sort   =   O(n^2)
       selectionsort =   O(n^2)
       insertionsort =   O(n^2)
       inbuilt       =   O(n logn)
      countingsort   =   O(n+largest no. in array) */
    
    public static void bubblesort(int array[]){
        int swap=0;
        for(int i=0;i<=array.length-2;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                    swap++;
                }
            }
        }System.out.println("number of swaps="+swap);
    }
    public static void Selectionsort(int array[]){
        /* In selection sorting pick the smallest from unsorted array,
        put it at the beginning*/
        int swap=0;
        for(int i=0;i<array.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minPos]){
                    minPos=j;
                }
            }
            int t=array[i];
            array[i]=array[minPos];
            array[minPos]=t;
            swap++;
        }System.out.println(swap);
    }
    public static void insertionsort(int array[]){
        for(int i=1;i<array.length;i++){
            int curr=array[i];
            int pre=i-1;
            //finding the correct position for current value to insert
            while(pre>=0 && array[pre]>curr){
                array[pre+1]=array[pre];
                pre--;
            }
            //insertion in correct position
            array[pre+1]=curr;
        }
    }
    public static void countingsort(int array[]){
        int largest=Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            largest=Math.max(largest,array[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                array[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String args[]){
        int array[]={5,4,1,3,2};
        System.out.println("array befor sort=");
        print(array);
       // Selectionsort(array);
        //bubblesort(array);
       // insertionsort(array);
       //Arrays.sort(array);//inbuilt
      // Arrays.sort(array,1,4);//Array.sort(arrar,starting index, ending index)
                              //ending index is non-inclusive.
        countingsort(array);                      

        System.out.println("after sort=");
        print(array);
    }
}
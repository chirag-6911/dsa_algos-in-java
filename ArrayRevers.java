
public class ArrayRevers{
    public static void revers(int array[]){
        int f=0;
        int l=array.length-1;
        while(f<=l){
            int t;
            t=array[f];
            array[f]=array[l];
            array[l]=t;
            f++;
            l--;
        }
    }public static void print(int array[]){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]+" ");
        }System.out.println();
    }
    public static void main(String args[]){
        int array[]={1,2,3,4,5};
        print(array);
        revers(array);
        print(array);

    }
}
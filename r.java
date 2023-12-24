public class r{
    public static void main(String args[]){
        int array[]={5,4,1,3,2,7,6,8};
        selectionsort(array);
        print(array);
    }

    public static void print(int arr[]){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length-2;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }
    public static void selectionsort(int arr[]){
        for(int i = 0; i<arr.length; i++){
            int minpos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minpos]){
                    minpos=j;
                }
            }
            int t = arr[minpos];
            arr[minpos]= arr[i];
            arr[i]=t;
        }
    }
    public static void insertionsort(int arr[]){
        for(int i = 1; i<arr.length; i++){
            int curr=arr[i];
            int pre=i-1;
            while(pre>=0 && arr[pre]>curr){
                arr[pre+1]=arr[pre];
                pre--;
            }
            arr[pre+1]=curr;
        }
    }
}
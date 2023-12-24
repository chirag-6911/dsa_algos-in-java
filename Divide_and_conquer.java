public class Divide_and_conquer{
    public static void main(String args[]){
        int arr[]={4,5,6,7,0,1,2};
       
        System.out.print( Search(arr,0,0,arr.length-1));



    }

    public static void printarray(int arr[]){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void Merge_sort(int arr[],int si, int ei){
        //base case
        if(si>=ei){
            return;
        }
        //kaam
        int mid = si + (ei-si)/2;

        Merge_sort(arr,si,mid);//left part
        Merge_sort(arr,mid+1,ei);//right part
        
        
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si, int mid, int ei){  
        int temp[]= new int[ei-si+1];
        int i = si;//iterator for left
        int j = mid+1;//iterator for right
        int k = 0;//iterator for temp array
        
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

        //left remaining part
        while(i<=mid){
          temp[k++] = arr[i++];  
        }
        //right remaining part 
        while(j<=ei){
          temp[k++] = arr[j++];  
        }

        // copy temp to orognal
        for(k=0, i = si; k < temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void Quick_sort(int arr[],int si, int ei){
        //base case
        if(si>=ei){
            return;
        }
        int pivotindex = partition(arr,si,ei);
        Quick_sort(arr,si,pivotindex-1);//left
        Quick_sort(arr,pivotindex+1,ei);//right   

    }

    public static int partition(int arr[],int si, int ei){
        int pivot =  arr[ei];
        int i = si-1;//to place for smaller element than pivot
        
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;  
    }


    //search in Rotated Sorted array.

    public static int Search(int arr[], int target, int si, int ei){
        //base case
        if(si>ei){
            return -1;
        }

        // kaam
        int mid = si+ (ei-si)/2;
        //found case

        //case 1: 
        if(target==arr[mid]){
            return mid;
        }

        //case 2: 
        if(arr[si]<=arr[mid]){
            //case a:
            if(arr[si] <= target && target <= arr[mid]){
                return Search(arr,target,si,mid);
            }else{
                //case b:
                return Search(arr,target,mid+1,ei);
            }
        }else{//case 3:
            //case a:
            if(arr[mid] <= target && target <= arr[ei]){
                return Search(arr,target,mid+1,ei);
            }else{
                //case b:
                return Search(arr,target,si,mid);
            }
        }
        
    }
}
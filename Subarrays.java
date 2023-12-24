//code to get max & min sum of subarrays using using diff. methods

public class Subarrays{
    public static void brute(int array[]){
        int c=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){int sum = 0;
                for(int k=i;k<=j;k++){
                    System.out.print(" "+array[k]+" ");
                    sum+=array[k];
                }c++;
                System.out.println(" = "+ sum);
                if(sum>max){
                    max=sum; 
                }if(sum<min){
                    min=sum;
                }
            }System.out.println();
        }System.out.println("total sub arrays = "+c);
        System.out.println("maximum sum of subarray = "+max);
        System.out.println("minimum sum of subarrays = "+min);
    }
    public static void prefix(int array[]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum = 0;
        int prevalue[] = new int[array.length];
        prevalue[0]=array[0];
        for(int i=1;i<prevalue.length;i++){
            prevalue[i]=prevalue[i-1]+array[i];
        }
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
               sum=0;
                sum = i==0 ?prevalue[j] : prevalue[j]-prevalue[i-1];
                if(sum>max){
                    max=sum;
                }if(sum<min){
                    min=sum;

               }
                }
        }
        System.out.println("maximum sum of subarray is= "+max);
        System.out.print("minimum sum of subarray is= "+min);

    }public static void kadane(int array[]){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            sum+=array[i];
            if(sum<0){
                sum=0;
            }if(max<sum){
                max=sum;
            }
        }System.out.print("maximum sum of subarray is = "+ max);

    }
    public static void main(String args[]){
        int array[]={-2,-3,4,-1,-2,1,5,-3};
        kadane(array);
    }
}
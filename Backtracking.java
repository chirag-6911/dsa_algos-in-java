public class Backtracking{

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void changearr(int arr[],int i ,int val ){
        //base case
        if(arr.length==i){
            printarr(arr);
            return;
        }
        //recursion
        arr[i]=val;
        changearr(arr,i+1,val+1);//fnx call step
        arr[i]=arr[i]-2;//backtracking step
    }

    public static void permutations(String str, String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0; i<str.length(); i++){
            char curr= str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            permutations(newstr,ans+curr);
        }
    }
    public static void findsubsets(String str, String ans, int i ){
        //base case
        if(i == str.length()){
            if(ans.length()==0){
                System.out.print("null");
            }else{
            System.out.println(ans);
            }
            return;
        }
        //recursion
        //yes choice
        findsubsets(str,ans+str.charAt(i),i+1);
        //no choice
        findsubsets(str,ans,i+1);//backtrack
        
    }
    public static void main(String args[]){
        String str = "123456";
        permutations(str,"");
    }

    
}
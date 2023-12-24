import java.util.*;

public class inter{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 10;
        for(int i=n; i>0; i--){
            if(check(n)==true){
                System.out.print(n);
            }
            
        }
        
    }
    public static boolean check(int n){

        if(n==1 || n==2){
            return true;
        }
        for(int i=n; i>2; i--){
            if(n%2==0){
                return false;
            }
            
        }
        return true;
    }
}
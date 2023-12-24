//loops using recursions
import java.util.*;

public class Recursions{
    public static void main(String [] args){
        
        Binary_string(3,0,"");
    }

    public static void Printdec(int n){
        if(n==1){
            System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");
            Printdec(n-1);
        
    }
    public static void Printinc(int n){
        if(n==1){
            System.out.print(1+" ");
            return;
        }
        Printinc(n-1);
        System.out.print(n+" ");
    }

    public static int factorial_n(int n){
        if(n==0){
            return 1;
        }
        int fn_1 = factorial_n(n-1);
        int fn = n*fn_1;
        return fn;
    }


    public static int Sum(int n){
        if(n==1){
            return 1;
        }
        int N = n+Sum(n-1);
        return N;
    }

    public static int Fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        //int n_1=Fibonacci(n-1);
        //int n_2=Fibonacci(n-2);
        //int N = n_1 + n_2;
        int N = Fibonacci(n-1)+ Fibonacci(n-2);
        return N;
    }
    public static boolean is_Sorted(int array[], int i){
        
        if(i==(array.length-1)){
            return true;
        }
        
        
        if(array[i]>array[i+1]){
            return false;
        }

        return is_Sorted(array,i+1);
    }

    public static int first_Occurance(int array[],int i, int key){
        if(i==array.length){
            return -1;
        }
        
        if(array[i]==key){
            return i;
        }

        return first_Occurance(array,i+1,key);
    }

   /* public static int Last_Occurance(int array[],int i,int key){
        if(i==0){
            return -1;
        }
        
        if(array[i]==key){
            return i;
        }

        return first_Occurance(array,i-1,key);
    }*/

    public static int Last_Occurance(int array[],int i,int key){
        if(i==array.length-1){
            return -1;
        }
        int isfound = Last_Occurance(array,i+1,key);
        if(isfound == -1 && array[i] == key){
            return i;
        }

        return isfound;
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }

    public static int Opti_power(int x, int n){
        if(n==1){
            return x;
        }

        int half = Opti_power(x,n/2);

        if((n%2) == 0){
            return half*half;
        }else{
            return x*half*half;
        }
    }
    public static int Tilling_problem(int n){
        if(n==0 || n==1){
            return 1;
        }

        int v = Tilling_problem(n-1);
        int h = Tilling_problem(n-2);
        return v+h;
    }

    public static void Remove_Duplicate(String str, int i, StringBuilder newstr, boolean map[]){
        if(i==str.length()){
            System.out.print(newstr);
            return;
        }

        char currChar = str.charAt(i);
        if(map[currChar-'a'] == true){
            Remove_Duplicate(str,i+1,newstr,map);
        }else{
            map[currChar-'a'] = true;
            Remove_Duplicate(str,i+1,newstr.append(currChar),map);
        }
    }

    public static int Friend_pair(int n){
        if(n==1 || n==2){
            return n;
        }

        //choice
        // single = Friend_pair(n-1);
        // pair = (n-1)*Friend_pair(n-2);
        int totalWays = Friend_pair(n-1) + (n-1)*Friend_pair(n-2);
        return totalWays;
    }


    //print all binary strings of size N without consecutive ones.
    public static void Binary_string(int n, int lastplace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam
        if(lastplace == 0 ){
            Binary_string(n-1,0,str+"0");
            Binary_string(n-1,1,str+"1");
        }else{
            Binary_string(n-1,0,str+"0");
        }
    }

}
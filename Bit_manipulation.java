import java.util.*;
//rules are in the notes.
public class Bit_manipulation{
    //to check the no. is odd or even using bit manipulation
    public static void  o_e(int n){
        if((n & 1 ) == 0){
            System.out.print("even");
        }else{
            System.out.print("odd");
        }
    }public static void fast_exponantiation(int a , int n){
        int ans = 1;
        while(n>0){
            if((n&1)!=0){
                ans *= a;
                a*=a;
                n=n>>1;
            }else{
                a*=a;
                n=n>>1;
            }

        }
        System.out.print(ans);
    }
    public static void count_set_bit(int n){
        int count = 0;
        int i = 0;
        while((n>>i)>0){
            if(((n>>i)&1)>0){
                count++;
                i++;
            }else{
                i++;
            }
        }System.out.print(count);
    }
     
    public static boolean power_of_two_or_not(int n){
        if((n & (n-1)) == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void clear_range_of_bits(int n, int i, int j){
        //b=bitmask
        int b1 = (~0)<<(j+1);
        int b2 = (~((~0)<<(i)));
        int b = b1|b2;
        n = n & b ; 
        System.out.print(n); 
    }
    public static void clear_last_i_bits(int n, int i){
        int bitmask = (~0)<<i;
        n = n & bitmask;
        System.out.print(n);
    }
    public static void get_i_bit(int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter i = ");
        int i = sc.nextInt();
        if((n & (1<<i))==0){
            System.out.print(" i'th bit is 0");
        }else{
            System.out.print("i'th bit is 1");
        }
    }
    public static void update_bit(int n){
        System.out.print("if want to set bit press 1 or if you want to clear bit press 2 = ");
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        if(b==1){
            set_i_bit(n);
        }else{
            clear_i_bit(n);
        }
    }
    public static void set_i_bit(int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter i = ");
        int i = sc.nextInt();
        n = n|(1<<i);
        System.out.print(n);
    }
    public static void clear_i_bit(int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter i = ");
        int i = sc.nextInt();
        n=n&(~(1<<i));
        System.out.print(n);
    }
    public static void main(String args[]){
       System.out.println(5&6);//binary AND operator= &
        System.out.println(5|6);//binary OR operator= |
        System.out.println(5^6);//binary XOR operator= ^
        System.out.println(~5);//binary one's complement operator= ~ this is single bit operator
        System.out.println(5<<2);//binary left shift operator= <<
        System.out.println(5>>2);//binary right shift operator= >> 
       /* Scanner sc = new Scanner(System.in);
        System.out.print("enter the no. =");
        int n = sc.nextInt();
        System.out.print("enter power = ");
        int i = sc.nextInt();
       // System.out.print("enter end point = ");
       // int j= sc.nextInt();
        fast_exponantiation(n,i);*/
    }
}
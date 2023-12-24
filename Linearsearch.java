import java.util.*;

public class Linersearch{
    public static int menu(int number[], int key){
        for(int i = 0;i<number.length; i++){
            if(key==number[i]){
                return i;
            }
        }return -1;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the key no. = ");
        int key = sc.nextInt();
        int number[]= {1,2,3,4,5,6,7,8,12,32,14};
        if(menu(number,key)==-1){
            System.out.print("gaand maro pancho");
        }else{
            System.out.print("ehni var gaand maru mai teri = " +  menu(number,key));
        }
    }
}
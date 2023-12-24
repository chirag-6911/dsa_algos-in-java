import java.util.*;

public class Strings{
   /* public static boolean palindrom(String str){
        int n=str.length()-1;
        for(int i=0 ;i<=n;i++){
            if(str.charAt(i) != str.charAt(n)){
                return false;
            }
            n--;
        } 
        return true;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String word=sc.next();
        if(palindrom(word) == true){
            System.out.print("word is palindrom");
        }else{
            System.out.print("word isn't palindrom");
        }
        
        
    }*/
    public static void substring(String str,int s,int e){
        String subS="";
        while(s<e){
            subS+=str.charAt(s);
            s++;
        
        }System.out.print(subS);
    }
   
    public static void main(String args[]){
       //for sub string=
        /*Scanner sc = new Scanner(System.in);
        System.out.print("enter string = ");
        String str=sc.nextLine();
        System.out.print("enter starting index (starting index is included) =");
        int s=sc.nextInt();
        System.out.print("enter ending index (ending index is excluded)=");
        int e=sc.nextInt();
        substring(str,s,e);*/
        //in built function in for substring in java=
        /*str.substing(starting index (included), ending index(excluded))*/
      //shortest distance=
       /* String d="WNEENESENNNW";
        int x=0;
        int y=0;
        int i=0;
        while(i<d.length()){
            if(d.charAt(i) == 'N'){
                y++;
            }
            else if(d.charAt(i) == 'S'){
                y--;
            }
            else if(d.charAt(i) == 'W'){
                x--;
            }
            else{
                x++;
            }
            i++;
        }
        float dis=(float)Math.sqrt((x*x)+(y*y));
        System.out.print("shortest path to rech is = "+dis);
   */ 
  //compare strings function = 
  /*String fruits[]={"apple","mango","banana"};
  String largest=fruits[0];
  for(int i=1;i<fruits.length;i++){
    if(largest.compareTo(fruits[i])<0){
        largest=fruits[i];
    }
    
  }System.out.print(largest);*/
  }
}
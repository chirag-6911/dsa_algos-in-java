import java.util.*;


//Sb = String builder
public class Sb{
    public static String upppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)==' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
        
    }
    public static String comp(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            int count=1;
            while(i<str.length()-1 && str.charAt(i+1)==str.charAt(i)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count);
            }
            count=1;
        }
        return sb.toString();
    }
    public static void main(String args[]){
        /*StringBuilder sb = new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }
        System.out.print(sb);*/
        //String str="hi, i am chirag ";
        //System.out.print(upppercase(str));
        String str = "abcdS";
        System.out.print(comp(str));

    }
}
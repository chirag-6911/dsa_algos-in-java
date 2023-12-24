import java.util.*;

public class As4{
    public static int count_vowel(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e'|| str.charAt(i)=='i'|| str.charAt(i)=='o'|| str.charAt(i)=='u'){
                count++;
            }
        }return count;
    }
    public static boolean anagram(String str1, String str2){
        if(str1.length()==str2.length()){
            char arr1[]=str1.toCharArray();
            char arr2[]=str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for(int i=0; i<arr1.length; i++){
                if(arr1[i]!=arr2[i]){
                    return false;
                }
            }
        }else{
            return false;
            }
            return true;
    }
    public static void main(String args[]){
       /* Scanner sc = new Scanner(System.in);
        System.out.print("enter string =");
        String str = sc.nextLine();
        System.out.print("no. of lowercase vowels in string is "+count_vowel(str));*/
        String str1 = "care";
        String str2 = "study";
        if(anagram(str1,str2) == true){
            System.out.print("given strings are anagram");
        }else{
            System.out.print("given strings are not anagram");
        }
    }
}
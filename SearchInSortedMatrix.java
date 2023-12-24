import java.util.*;

public class SearchInSortedMatrix{
    
    public static void staircasesearch(int Matrix[][],int key){
        int i=0,j=Matrix[0].length-1;
        while(i<Matrix.length && j>=0){
            if(key<Matrix[i][j]){
                j--;
            }else if(key>Matrix[i][j]){
                i++;
            }else if(key==Matrix[i][j]){
                System.out.print("key is at index = "+i+","+j);
                return;
            }
        }System.out.print("key not found");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the key = ");
        int key=sc.nextInt();
        int Matrix[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        staircasesearch(Matrix,key);
    }
}
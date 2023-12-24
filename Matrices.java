import java.util.*;
public class Matrices{
    public static boolean search(int array[][],int key){
    for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]==key){
                    System.out.print("key is at index = "+i+","+j+" ");
                    return true;
                }
            }
        }return false;

}
    public static void  main(String args[]){
        int Matrix[][]=new int[4][3];
        //Matrix.length= for length of rows;
        //Matrix[0].length = for length of colums;
        int n=Matrix.length,m=Matrix[0].length;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Matrix[i][j]=sc.nextInt();
            }
        }
        System.out.print("enter the key =");
        int key=sc.nextInt();
        search(Matrix,key);

        
    }
}
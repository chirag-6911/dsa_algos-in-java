import java.util.*;

public class SpiralMatrix{
    public static void transpose(int array[][]){
        int tarray[][]=new int [array[0].length][array.length];
        for(int i=0;i<array.length;i++){
            for(int  j=0;j<array[0].length;j++){
                tarray[j][i]=array[i][j];
            }
        }for(int i = 0;i<tarray.length;i++){
            for(int j = 0;j<tarray[0].length;j++){
                System.out.print(i+","+j+"="+tarray[i][j]+";");
            }
        }
    }
    public static void diagonalsum(int Matrix[][]){
        int sum = 0;
        //o(n^2)
        /*for(int i=0;i<Matrix.length;i++){
            for(int j = 0;j<Matrix[0].length;j++ ){
                if(i==j){
                    sum+=Matrix[i][j];
                }
                else if(i+j == Matrix.length-1){
                    sum+=Matrix[i][j];
                }
            }
        }*/
        //o(n)
        for(int i =0;i<Matrix.length;i++){
            //pd
            sum+=Matrix[i][i];
            //sd
            if(i != Matrix.length-1-i){
            sum+=Matrix[i][Matrix.length-1-i];}}System.out.print(sum);
    }
    public static void Spiral(int Matrix[][]){
        int startrow = 0;
        int endrow = Matrix.length-1;
        int startcolum =0;
        int endcolum = Matrix[0].length-1;
        while(startrow<=endrow && startcolum<=endcolum){
        //toprow
        for(int j=startcolum;j<=endcolum;j++){
            System.out.print(Matrix[startrow][j]+" ");
        }
        //rightcolum
        for(int i=startrow+1;i<=endrow;i++){
            System.out.print(Matrix[i][endcolum]+" ");
        }
        //bottomrow
        for(int j=endcolum-1;j>=startcolum;j--){
            if(startrow == endrow){
                break;
            }
            System.out.print(Matrix[endrow][j]+" ");
        }
        //leftcolum
        for(int i=endrow-1;i>=startrow+1;i--){
            if(startcolum == endcolum){
                break;
            }
            System.out.print(Matrix[i][startcolum]+" ");
        }
         startrow++;
         endrow--;
         startcolum++;
         endcolum--; 
        }
    }
    public static void main(String args[]){
       /* Scanner sc = new Scanner(System.in);
        System.out.print("enter number of rows = ");
        int row=sc.nextInt();
        System.out.print("enter number of colums = ");
        int colums=sc.nextInt();
        int Matrix[][]=new int[row][colums];
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[0].length;j++){
                Matrix[i][j]=sc.nextInt();
            }
        }*/
        int Matrix[][]={{1,2,3},{4,5,6}};
        for(int i = 0;i<Matrix.length;i++){
            for(int j = 0;j<Matrix[0].length;j++){
                System.out.print(i+","+j+"="+Matrix[i][j]+";");
            }
        }
        System.out.println();
        transpose(Matrix);

    }
}

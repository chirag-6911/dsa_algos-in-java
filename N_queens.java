public class N_queens{
    public static boolean issafe(char board[][],int row, int col){
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal left up
        for(int i = row-1 ,j = col-1 ; j>=0 && i>=0 ; j--,i--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagonal right up
        for(int i = row-1, j = col+1; j<board.length && i>=0 ; j++,i--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void nqueens(char board[][], int row){
        if(row==board.length){
            //printBoard(board);
            count++;
            return;
        }int cout=0;
        for(int j=0;j<board.length;j++){
            if(issafe(board,row,j)){
                board[row][j]='Q';
                nqueens(board,row+1);
                board[row][j]='X';
            }

        }
    }

    public static boolean nqueen(char board[][], int row){
        if(row==board.length){
            //printBoard(board);
            return true;
        }
        int cout=0;
        for(int j=0;j<board.length;j++){
            if(issafe(board,row,j)){
                board[row][j]='Q';
                if(nqueen(board,row+1)){
                    return true;
                }
                board[row][j]='X';
            }
        }
        return false;

    }

    

    public static void printBoard(char bor[][]){
        System.out.println("------chess board------");
        for(int i=0; i<bor.length; i++){
            for(int j=0;j<bor.length;j++){
                System.out.print(bor[i][j]+" ");
            }
            System.out.println();

        }
    }

    static int count = 0;
    public static void main(String args[]){
        int n = 2;
        char board[][]= new char[n][n];
        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        if(nqueen(board,0)){
            System.out.println("solution possible");
            printBoard(board);
        }else{
            System.out.print("solution not possible");
        }

    }
}
package Backtracking;



public class SudokuSolver {
    public static void main(String[] args) {

        int[][]board={
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        if(solveBoard(board))
        {
            display(board);
        }
        else
        {
            System.out.println("Cant solve");
        }
    }

    static boolean isSafe(int[][]board,int row,int col,int num)
    {
        //check in row
        for(int i=0;i<board.length;i++)
        {
            if(board[row][i]==num)
            {
                return false;
            }
        }

        //check column
        for(int[]nums:board) {
            if (nums[col] == num)
            {
                return false;
            }
        }

        //check sub square
        int sqrt=(int)Math.sqrt(board.length);
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;

        for(int r=rowStart;r<rowStart+sqrt;r++)
        {
            for(int c=colStart;c<colStart+sqrt;c++)
            {
                if(board[r][c]==num)
                {
                    return false;
                }
            }
        }

        //if everything fits
        return true;
    }

    static  boolean solveBoard(int[][]board)
    {
        int row=-1,col=-1;
        boolean emptyLeft=true;

        for(int i=0;i< board.length;i++)
        {
            for (int j=0;j< board.length;j++)
            {
                if(board[i][j]==0)
                {
                    emptyLeft=false;
                    row=i;
                    col=j;
                    break;
                }

            }
            if(emptyLeft==false)
            {
                break;
            }
        }

        //sudoku is solved,no empty element left
        if(emptyLeft)
        {
            return true;
        }

        //backtrack

        for(int num=1;num<=9;num++)
        {
            if(isSafe(board,row,col,num))
            {
                board[row][col]=num;
                if(solveBoard(board))
                {
                    //solved
                    return true;
                }
                else {
                    //backtrack
                    board[row][col]=0;
                }
            }

        }

        return false;

    }

     static void display(int[][] board) {
        for (int i=0;i< board.length;i++)
        {
            for (int j=0;j< board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

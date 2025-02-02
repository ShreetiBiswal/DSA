package Backtracking;
import java.lang.reflect.Array;
import java.util.*;
public class maze {
    public static void main(String[] args) {

        boolean[][] maze=new boolean[5][5];


        System.out.println(NQueens(maze,0));


        }

    static int countMaze(int r,int c)
    {
        if(r==1 || c==1)
        {
            return 1;
        }

        int left=countMaze(r-1,c);
        int right=countMaze(r,c-1);

        return left+right;
    }

    static ArrayList<String> mazePath(String p,int r,int c)
    {
        ArrayList<String >ans=new ArrayList<>();

        if(r==1 && c==1)
        {
            ans.add(p);
            return ans;
        }

        if(c>1)
        {
           ans.addAll(mazePath(p+"H",r,c-1));
        }
        if(r>1)
        {
          ans.addAll( mazePath(p+"V", r-1,c));
        }
        if(r>1 && c>1)
        {
            ans.addAll( mazePath(p+"D", r-1,c-1));
        }

        return ans;
    }

    static void obstacleMaze(boolean[][]maze,String p,int r,int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        if(c<maze[0].length-1)
        {
            obstacleMaze(maze,p+"H",r,c+1);
        }
        if(r<maze.length-1)
        {
            obstacleMaze(maze,p+"V",r+1,c);
        }
    }

    static void allPath(boolean[][]maze,String p,int r,int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }

        //Done to keep track of path so that it is not repeated
        maze[r][c]=false;

        if(c<maze[0].length-1)
        {
            allPath(maze,p+"R",r,c+1);
        }
        if(r<maze.length-1)
        {
            allPath(maze,p+"D",r+1,c);
        }
        if(r>0)
        {
            allPath(maze,p+"U",r-1,c);
        }
        if(c>0)
        {
            allPath(maze,p+"L",r,c-1);
        }

        //after returning the fun we have to reverse the modifications we made in original array
        maze[r][c]=true;
    }

    static void allPathPrint(boolean[][]maze,String p,int r,int c,int[][]path,int step)
    {
        path[r][c]=step;
        if(r==maze.length-1 && c==maze[0].length-1)
        {
           for (int[]arr:path)
           {
               System.out.println(Arrays.toString(arr));
           }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c])
        {
            return;
        }

        //Done to keep track of path so that it is not repeated
        maze[r][c]=false;


        if(c<maze[0].length-1)
        {
            allPathPrint(maze,p+"R",r,c+1,path,step+1);
        }
        if(r<maze.length-1)
        {
            allPathPrint(maze,p+"D",r+1,c,path,step+1);
        }
        if(r>0)
        {
            allPathPrint(maze,p+"U",r-1,c,path,step+1);
        }
        if(c>0)
        {
            allPathPrint(maze,p+"L",r,c-1,path,step+1);
        }

        //after returning the fun we have to reverse the modifications we made in original array
        maze[r][c]=true;
        path[r][c]=0;
    }

    static int NQueens(boolean[][]board,int r)
    {
        if(r==board.length)
        {
            display(board);
            return 1;
        }
        int c=0;

        for(int col=0;col<board.length;col++)
        {
            if(isSafe(board,r,col))
            {
                board[r][col]=true;
                c+=NQueens(board,r+1);
                board[r][col]=false;
            }
        }

        return c;
    }

    private static boolean isSafe(boolean[][] board, int r, int col) {
        for(int i=0;i<r;i++)
        {
            //vertical row
            if(board[i][col])
            {
                return false;
            }
        }

        //left diagonal
        int r2=r,c2=col;


        while(r2>=0 && c2>=0)
        {
            if(board[r2--][c2--])
            {
                return false;
            }
        }

        //right diagonal
        r2=r; c2=col;
        while(r2>=0 && c2< board.length)
        {
            if(board[r2--][c2++])
            {
                return false;
            }
        }
        return true;

    }

    private static void display(boolean[][] board) {

        for(boolean[]r:board)
        {
            for(boolean c:r)
            {
                if(c)
                {
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

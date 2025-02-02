package dynamicProgramming;

public class Knapsack01 {

    static  int[][]t=new int[100+1][1000+1]; //100,1000 may be constraints


    public static void main(String[] args) {

        for(int i=0;i<=100;i++){
            for(int j=0;j<=1000;j++){
                t[i][j]=-1;
            }
        }

        int[] wt={1,2,3};
        int[] val={10,15,40};

        System.out.println(KnapSackRecursive(wt,val,6,3));
        System.out.println(KnapsackTopDown(wt,val,6,3));
        System.out.println(KnapSackMemo(wt,val,6,3));
    }

    public static int KnapSackRecursive(int[]wt,int[]profit,int W,int n){
        if(n==0||W==0)return 0;

        int l=KnapSackRecursive(wt,profit,W,n-1);//Not including current item

        if(wt[n-1]>W) return l;//As knapsack cannot hold the current item
        else{
            int r=KnapSackRecursive(wt,profit,W-wt[n-1],n-1)+profit[n-1];
            return l>r?l:r;
        }
    }


    public static int KnapsackTopDown(int[]wt,int[]val,int W,int n){

        int [][]t=new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            t[i][0]=0;
        }

        for(int i=0;i<W+1;i++){
            t[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){

                if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }else{
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }
            }
        }

        return t[n][W];
    }
    public static int KnapSackMemo(int[]wt,int[]val,int W,int n){

        if(n==0 || W==0)return 0;

        if(t[n][W]!=-1)return t[n][W];

        int l=KnapSackMemo(wt,val,W,n-1);

        if(wt[n-1]>W){
            t[n][W]=l;
            return t[n][W];
        }else{
            int r=KnapSackMemo(wt,val,W-wt[n-1],n-1)+val[n-1];
            t[n][W]=l>r?l:r;
            return t[n][W];
        }
    }
}
